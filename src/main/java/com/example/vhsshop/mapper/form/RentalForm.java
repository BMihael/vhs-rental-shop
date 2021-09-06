package com.example.vhsshop.mapper.form;

import com.example.vhsshop.mapper.dto.VhsDto;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RentalForm {

    /*
    @NotNull(message= "duration must not be null")
    @Min(value=1, message="duration must be greater than 1")
    private Integer duration;
*/
    @NotNull(message= "End date must not be empty")
    private Date endDate;

    @NotNull(message= "user id must not be empty")
    private Long userId;

    private VhsForm vhs;
}