package com.demo.domain.entity.order.factory;

import com.demo.domain.entity.order.OrderEntity;
import com.demo.domain.entity.order.repository.OrderRepository;
import com.demo.dto.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Component
public class OrderFactory {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity create(CreateOrderRequest request) {
        return OrderEntity.builder()
                .address(request.getAddress())
                .orderRepository(orderRepository).build();
    }

    public OrderEntity create() {
        return OrderEntity.builder()
                .orderRepository(orderRepository).build();
    }
}