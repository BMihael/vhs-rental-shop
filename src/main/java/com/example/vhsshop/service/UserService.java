package com.example.vhsshop.service;

import com.example.vhsshop.mapper.dto.UserDto;
import com.example.vhsshop.model.User;

public interface UserService {
    User get(Long id);
    UserDto getUserById(Long id);
}