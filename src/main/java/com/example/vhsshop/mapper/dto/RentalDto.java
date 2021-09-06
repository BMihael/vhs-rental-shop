package com.example.vhsshop.mapper.dto;

import com.example.vhsshop.mapper.dto.special.UserDtoWithoutRental;
import lombok.Data;
import java.util.Date;

@Data
public class RentalDto {
    private Long id;
    private Date orderDate;
    private Date endDate;
    private UserDtoWithoutRental user;
    private VhsDto vhs;
}