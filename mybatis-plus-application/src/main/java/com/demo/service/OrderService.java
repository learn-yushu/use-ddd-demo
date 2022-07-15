package com.demo.service;

import com.demo.dto.CreateOrderRequest;
import com.demo.vo.OrderVO;

/**
 * @author 玉书
 * @date 2022/7/15
 */
public interface OrderService {

    /**
     * @param orderDto
     */
    boolean createOrder(CreateOrderRequest orderDto);

    /**
     * @param orderId
     * @return
     */
    OrderVO queryOrderById(Long orderId);

}