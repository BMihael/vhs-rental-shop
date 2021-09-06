package com.example.vhsshop.mapper.dto;

import com.example.vhsshop.mapper.dto.special.RentalDtoWithoutUser;
import lombok.Data;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String username;
    private List<RentalDtoWithoutUser> rentals;
}