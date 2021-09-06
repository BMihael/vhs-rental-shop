package com.example.vhsshop.mapper.form;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RentalForm {

    @NotNull(message= "End date must not be empty")
    private Date endDate;

    @NotNull(message= "user id must not be empty")
    private Long userId;

    private VhsForm vhs;
}