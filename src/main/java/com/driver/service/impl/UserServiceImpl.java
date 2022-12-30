package com.driver.service.impl;

import com.driver.Converter.UserConverter;
import com.driver.io.entity.UserEntity;
import com.driver.io.repository.UserRepository;
import com.driver.service.UserService;
import com.driver.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) throws Exception {
        userRepository.save(UserConverter.dtoToEntity(user));
        return user;
    }

    @Override
    public UserDto getUser(String email) throws Exception {
        return UserConverter.entityToDto(userRepository.findByEmail(email));
    }

    @Override
    public UserDto getUserByUserId(String userId) throws Exception {
        return UserConverter.entityToDto(userRepository.findByUserId(userId));
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) throws Exception {
        userRepository.update(UserConverter.dtoToEntity(user));
        return user;
    }

    @Override
    public void deleteUser(String userId) throws Exception {
        userRepository.delete(userRepository.findByUserId(userId));
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserEntity> list = (List<UserEntity>) userRepository.findAll();
        List<UserDto> returnList = new ArrayList<>();
        for(UserEntity user:list) returnList.add(UserConverter.entityToDto(user));
        return returnList;
    }
}