package com.example.vhsshop.mapper;

import com.example.vhsshop.mapper.dto.RentalDto;
import com.example.vhsshop.mapper.dto.UserDto;
import com.example.vhsshop.mapper.dto.VhsDto;
import com.example.vhsshop.mapper.form.RentalForm;
import com.example.vhsshop.model.Rental;
import com.example.vhsshop.model.User;
import com.example.vhsshop.model.Vhs;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    VhsDto vhsToVhsDto(Vhs vhs);
    Vhs vhsDtoToVhs(VhsDto vhsDto);
    RentalDto rentalToRentalDto(Rental rental);
    List<VhsDto> vhoListToVhsDtoList(List<Vhs> vhs);
    List<RentalDto> rentalListToRentalDtoList(List<Rental> rental);
    UserDto userToUserDto(User user);

    //Form
    Rental rentalFormToRental(RentalForm rentalForm);
}