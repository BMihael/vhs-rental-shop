package com.example.vhsshop.controller;

import com.example.vhsshop.mapper.dto.UserDto;
import com.example.vhsshop.model.response.ResponseMessage;
import com.example.vhsshop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        return new ResponseEntity<UserDto>(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteUser(@PathVariable Long id){
        return new ResponseEntity<ResponseMessage>(userService.deleteUser(id), HttpStatus.OK);
    }
}