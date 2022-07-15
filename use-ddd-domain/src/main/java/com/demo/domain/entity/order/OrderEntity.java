package com.demo.domain.entity.order;

import com.demo.domain.entity.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Data
@Builder
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class OrderEntity {

    private Long orderId;

    private String productName;

    private BigDecimal productPrice;

    private Long count;

    private BigDecimal totalPrice;

    private String address;

    private String mobileNumber;

    private Long userId;

    private OrderRepository orderRepository;

    public void save(){
        orderRepository.save(this);
    }

    public OrderEntity findById() {
        return orderRepository.findById(orderId);
    }

}