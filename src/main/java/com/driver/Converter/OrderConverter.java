package com.driver.Converter;

import com.driver.io.entity.OrderEntity;
import com.driver.model.request.OrderDetailsRequestModel;
import com.driver.model.response.OrderDetailsResponse;
import com.driver.shared.dto.OrderDto;

public class OrderConverter {

    public static OrderEntity dtoToEntity(OrderDto orderDto){
        return OrderEntity
                .builder()
                .id(orderDto.getId())
                .orderId(orderDto.getOrderId())
                .cost(orderDto.getCost())
                .items(orderDto.getItems())
                .userId(orderDto.getUserId())
                .status(orderDto.isStatus())
                .build();
    }

    public static OrderDto entityToDto(OrderEntity order){
        return OrderDto
                .builder()
                .id(order.getId())
                .orderId(order.getOrderId())
                .cost(order.getCost())
                .items(order.getItems())
                .userId(order.getUserId())
                .status(order.isStatus())
                .build();
    }

    public static OrderDetailsResponse dtoToDetailsResponse(OrderDto dto){
        return OrderDetailsResponse
                .builder()
                .orderId(dto.getOrderId())
                .cost(dto.getCost())
                .items(dto.getItems())
                .userId(dto.getUserId())
                .status(dto.isStatus())
                .build();
    }

    public static OrderDto detailsRequestModelToDto(OrderDetailsRequestModel requestModel){
        return OrderDto
                .builder()
                .items(requestModel.getItems())
                .cost(requestModel.getCost())
                .userId(requestModel.getUserId())
                .build();
    }

}
