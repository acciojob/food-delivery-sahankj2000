package com.driver.Converter;

import com.driver.io.entity.FoodEntity;
import com.driver.io.entity.UserEntity;
import com.driver.model.request.UserDetailsRequestModel;
import com.driver.model.response.UserResponse;
import com.driver.shared.dto.FoodDto;
import com.driver.shared.dto.UserDto;

public class UserConverter {

    public static UserEntity dtoToEntity(UserDto userDto){
        return UserEntity
                .builder()
                .id(userDto.getId())
                .userId(userDto.getUserId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
    }

    public static UserDto entityToDto(UserEntity user){
        return UserDto
                .builder()
                .id(user.getId())
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public static UserResponse dtoToResponse(UserDto dto){
        return UserResponse
                .builder()
                .userId(dto.getUserId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
    }

    public static UserDto detailsRequestModelToDto(UserDetailsRequestModel requestModel){
        return UserDto
                .builder()
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .email(requestModel.getEmail())
                .build();
    }

}
