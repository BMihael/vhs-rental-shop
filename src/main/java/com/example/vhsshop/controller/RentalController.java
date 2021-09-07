package com.example.vhsshop.controller;

import com.example.vhsshop.mapper.dto.RentalDto;
import com.example.vhsshop.mapper.form.RentalForm;
import com.example.vhsshop.model.response.ResponseMessage;
import com.example.vhsshop.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rental")
public class RentalController {

    private String controllerName;

    @Autowired
    public void setValues(@Value("${message.controller.rental}") String value) {
        this.controllerName = value;
    }

    @Autowired
    private RentalService rentalService;

    @GetMapping("/")
    public ResponseEntity<List<RentalDto>> getRentals(){
        return new ResponseEntity<List<RentalDto>>(rentalService.getRentals(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<RentalDto>> getRentalsByUserId(@PathVariable Long id){
        return new ResponseEntity<List<RentalDto>>(rentalService.getRentalsByUser(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RentalDto> saveRental(@Valid @RequestBody final RentalForm rentalForm){
        return new ResponseEntity<RentalDto>(rentalService.saveRental(rentalForm), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateRental(@Valid @RequestBody final RentalForm rentalForm, @PathVariable Long id){
        return new ResponseEntity<ResponseMessage>(rentalService.updateRental(rentalForm, id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteRental(@PathVariable Long id){
        return new ResponseEntity<ResponseMessage>(rentalService.deleteRental(id),HttpStatus.OK);
    }
}