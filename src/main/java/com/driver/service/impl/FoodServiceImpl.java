package com.driver.service.impl;

import com.driver.Converter.FoodConverter;
import com.driver.io.entity.FoodEntity;
import com.driver.io.repository.FoodRepository;
import com.driver.service.FoodService;
import com.driver.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public FoodDto createFood(FoodDto foodDto) {
        foodRepository.save(FoodConverter.dtoToEntity(foodDto));
        return foodDto;
    }

    @Override
    public FoodDto getFoodById(String foodId) throws Exception {
        return FoodConverter.entityToDto(foodRepository.findByFoodId(foodId));
    }

    @Override
    public FoodDto updateFoodDetails(String foodId, FoodDto foodDetails) throws Exception {
        foodRepository.update(FoodConverter.dtoToEntity(foodDetails));
        return foodDetails;
    }

    @Override
    public void deleteFoodItem(String id) throws Exception {
        foodRepository.delete(foodRepository.findByFoodId(id));
    }

    @Override
    public List<FoodDto> getFoods() {
        List<FoodEntity> list = (List<FoodEntity>) foodRepository.findAll();
        List<FoodDto> returnList  = new ArrayList<>();
        for(FoodEntity food:list){
            returnList.add(FoodConverter.entityToDto(food));
        }
        return returnList;
    }
}