package com.driver.Converter;

import com.driver.io.entity.FoodEntity;
import com.driver.model.request.FoodDetailsRequestModel;
import com.driver.model.response.FoodDetailsResponse;
import com.driver.shared.dto.FoodDto;

public class FoodConverter {

    public static FoodEntity dtoToEntity(FoodDto foodDto){
        return FoodEntity
                .builder()
                .id(foodDto.getId())
                .foodId(foodDto.getFoodId())
                .foodName(foodDto.getFoodName())
                .foodCategory(foodDto.getFoodCategory())
                .foodPrice(foodDto.getFoodPrice())
                .build();
    }

    public static FoodDto entityToDto(FoodEntity food){
        return FoodDto
                .builder()
                .id(food.getId())
                .foodId(food.getFoodId())
                .foodName(food.getFoodName())
                .foodCategory(food.getFoodCategory())
                .foodPrice(food.getFoodPrice())
                .build();
    }

    public static FoodDto detailRequestToDTO(FoodDetailsRequestModel requestModel){
        return FoodDto
                .builder()
                .foodName(requestModel.getFoodName())
                .foodCategory(requestModel.getFoodCategory())
                .foodPrice(requestModel.getFoodPrice())
                .build();
    }

    public static FoodDetailsResponse dtoToDetailsResponse(FoodDto dto){
        return FoodDetailsResponse
                .builder()
                .foodId(dto.getFoodId())
                .foodName(dto.getFoodName())
                .foodCategory(dto.getFoodCategory())
                .foodPrice(dto.getFoodPrice())
                .build();
    }

}
