package com.demo.domain.entity.order.repository;

import com.demo.domain.entity.order.OrderEntity;
import com.demo.domain.entity.order.converter.OrderConverter;
import com.tojaoomy.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Component
public class OrderRepository {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderConverter orderConverter;

    public void save(OrderEntity entity) {
        orderMapper.insert(orderConverter.toDataObject(entity));
    }

    public OrderEntity findById(Long orderId) {
        return OrderEntity.builder().build();
    }

}