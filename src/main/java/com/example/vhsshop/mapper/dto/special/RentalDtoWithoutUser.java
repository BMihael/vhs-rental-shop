package com.example.vhsshop.mapper.dto.special;

import com.example.vhsshop.mapper.dto.UserDto;
import com.example.vhsshop.mapper.dto.VhsDto;
import lombok.Data;

import java.util.Date;

@Data
public class RentalDtoWithoutUser {
    private Long id;
    private Integer duration;
    private Date orderDate;
    private VhsDto vhs;
}
