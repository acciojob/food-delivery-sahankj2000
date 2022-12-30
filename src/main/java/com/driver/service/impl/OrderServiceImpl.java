package com.driver.service.impl;

import com.driver.Converter.OrderConverter;
import com.driver.io.entity.OrderEntity;
import com.driver.io.repository.OrderRepository;
import com.driver.service.OrderService;
import com.driver.shared.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(OrderDto order) {
        orderRepository.save(OrderConverter.dtoToEntity(order));
        return order;
    }

    @Override
    public OrderDto getOrderById(String orderId) throws Exception {
        return OrderConverter.entityToDto(orderRepository.findByOrderId(orderId));
    }

    @Override
    public OrderDto updateOrderDetails(String orderId, OrderDto order) throws Exception {
        orderRepository.update(OrderConverter.dtoToEntity(order));
        return order;
    }

    @Override
    public void deleteOrder(String orderId) throws Exception {
        orderRepository.delete(orderRepository.findByOrderId(orderId));
    }

    @Override
    public List<OrderDto> getOrders() {
        List<OrderEntity> list = (List<OrderEntity>) orderRepository.findAll();
        List<OrderDto> returnList = new ArrayList<>();
        for(OrderEntity order:list) returnList.add(OrderConverter.entityToDto(order));
        return returnList;
    }
}