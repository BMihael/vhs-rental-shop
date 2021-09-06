package com.example.vhsshop.service.impl;

import com.example.vhsshop.exception.UserNotFoundException;
import com.example.vhsshop.mapper.MapStructMapper;
import com.example.vhsshop.mapper.dto.UserDto;
import com.example.vhsshop.model.User;
import com.example.vhsshop.model.response.ResponseMessage;
import com.example.vhsshop.model.response.UserResponseMessage;
import com.example.vhsshop.repository.UserRepository;
import com.example.vhsshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MapStructMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found!");
        }
        return user.get();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = get(id);
        return mapper.userToUserDto(user);
    }

    @Override
    public ResponseMessage deleteUser(Long id) {
        User user = get(id);
        userRepository.deleteById(id);
        return new UserResponseMessage("User deleted!");
    }
}