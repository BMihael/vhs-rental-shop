package com.example.vhsshop.controller;

import com.example.vhsshop.mapper.dto.VhsDto;
import com.example.vhsshop.service.impl.VhsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vhs")
public class VhsController {

    @Autowired
    private VhsServiceImpl vhsService;

    @GetMapping("/")
    public ResponseEntity<List<VhsDto>> getVhs(){
        return new ResponseEntity<List<VhsDto>>(vhsService.getVhs(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VhsDto> getVhsById(@PathVariable Long id){
        return new ResponseEntity<VhsDto>(vhsService.getVhsById(id),HttpStatus.OK);
    }
}