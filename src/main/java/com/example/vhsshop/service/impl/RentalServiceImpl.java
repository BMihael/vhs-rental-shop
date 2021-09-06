package com.example.vhsshop.service.impl;

import com.example.vhsshop.exception.*;
import com.example.vhsshop.mapper.MapStructMapper;
import com.example.vhsshop.mapper.dto.RentalDto;
import com.example.vhsshop.mapper.form.RentalForm;
import com.example.vhsshop.model.Rental;
import com.example.vhsshop.model.Role;
import com.example.vhsshop.model.Roles;
import com.example.vhsshop.model.response.RentalResponseMessage;
import com.example.vhsshop.model.User;
import com.example.vhsshop.model.response.ResponseMessage;
import com.example.vhsshop.repository.RentalRepository;
import com.example.vhsshop.service.RentalService;
import com.example.vhsshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private MapStructMapper mapper;

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private VhsServiceImpl vhsService;

    @Override
    public List<RentalDto> getRentals() {
        List<Rental> list = rentalRepository.findAll();
        return mapper.rentalListToRentalDtoList(list);
    }

    @Override
    public List<RentalDto> getRentalsByUser(Long id) {
        User user = userService.get(id);
        List<Rental> list = rentalRepository.findRentalByUserId(id);
        return mapper.rentalListToRentalDtoList(list);
    }

    @Override
    public ResponseMessage deleteRental(Long id) {
        Optional<Rental> rental = rentalRepository.findById(id);

        if(rental.isEmpty()){
            throw new RentalNotFoundException("Rental not found!");
        }

        String message = "";
        Integer feeDays = rentalRepository.getFeeDays(rental.get().getVhs().getId());
        if(feeDays<0){
            message += " You are late! Fee to be paid is: " + Math.abs(feeDays*5);
        }
        rentalRepository.deleteById(id);
        return new RentalResponseMessage("Rental returned!" + message);
    }


    private void checkUserRole(User user){
        for(Role role : user.getRoles()){
            if(role.getName().equals(Roles.ROLE_ADMIN.name()))
                throw new UserIsAdminException("Cannot rent vhs to admin!");
        }
    }

    @Override
    public RentalDto saveRental(RentalForm rentalForm) {
        User user = userService.get(rentalForm.getUserId());
        checkUserRole(user);

        Rental rental = mapper.rentalFormToRental(rentalForm);

        Date date = new Date();
        rental.setOrderDate(date);

        if(rentalForm.getEndDate().before(date)){
            throw new RentalEndDateInvalidException("Rental end date cannot be before order date!");
        }
        rental.setEndDate(rentalForm.getEndDate());
        rental.setUser(user);

        Optional<Rental> unavailableRentalOnDay = rentalRepository.findRentalUnavailableOnDay(rentalForm.getVhs().getId());

        if(unavailableRentalOnDay.isPresent()){
           throw new RentalOnSameDateForbiddenException("Cannot rent this resource on current date!");
        }

        rentalRepository.save(rental);
        RentalDto rentalDto = mapper.rentalToRentalDto(rental);
        return rentalDto;
    }

    @Override
    public ResponseMessage updateRental(RentalForm rentalForm, Long rentalId) {
        User user = userService.get(rentalForm.getUserId());
        checkUserRole(user);

        Optional<Rental> rentalOptional = rentalRepository.findById(rentalId);

        if(rentalOptional.get().getUser().getId()!=user.getId()){
            throw new UserDoesNotContainRentalException("User does not contain this rental!");
        }

        if(rentalForm.getEndDate().before(rentalOptional.get().getOrderDate())){
            throw new RentalEndDateInvalidException("Rental end date cannot be before order date!");
        }

        Long vhsId = rentalForm.getVhs().getId();
        if(rentalIsAlreadyRented(vhsId)){
            throw new VhsIsAlreadyRentedException("Vhs with id " + vhsId + " is already rented!");
        }

        if(rentalOptional.isPresent()){
            Rental rental = rentalOptional.get();
            rental.setId(rentalId);
            rental.setEndDate(rentalForm.getEndDate());
            rental.setVhs(mapper.vhsDtoToVhs(vhsService.getVhsById(rentalForm.getVhs().getId())));
            rentalRepository.save(rental);
            return new RentalResponseMessage("Rental updated");
        }
        throw new RentalNotFoundException("Rental not found!");
    }


    private boolean rentalIsAlreadyRented(Long id){
        return rentalRepository.findVhsIsRented(id);
    }
}