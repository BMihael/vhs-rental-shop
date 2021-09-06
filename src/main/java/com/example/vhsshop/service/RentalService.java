package com.example.vhsshop.service;

import com.example.vhsshop.mapper.dto.RentalDto;
import com.example.vhsshop.mapper.form.RentalForm;
import com.example.vhsshop.model.response.ResponseMessage;
import java.util.List;


public interface RentalService {
    List<RentalDto> getRentals();
    List<RentalDto> getRentalsByUser(Long id);
    ResponseMessage deleteRental(Long id);
    RentalDto saveRental(RentalForm rentalForm);
    ResponseMessage updateRental(RentalForm rentalForm, Long rentalId);
}