package com.example.vhsshop.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date orderDate;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    //ovdje je bilo cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}
    @ManyToOne(targetEntity = Vhs.class)
    @JoinColumn(name = "vhsId", updatable = true, nullable = true)
    @JsonIgnore
    private Vhs vhs;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId", updatable = false, nullable = true)
    @JsonIgnore
    private User user;

}
