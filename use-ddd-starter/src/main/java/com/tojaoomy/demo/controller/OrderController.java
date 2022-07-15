package com.tojaoomy.demo.controller;

import com.demo.dto.CreateOrderRequest;
import com.demo.service.OrderService;
import com.demo.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 * @date 2021/12/20
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @RequestMapping("/create")
    public boolean createAccount(CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }

    @RequestMapping("/queryById")
    public OrderVO queryOrderById(Long orderId) {
        return orderService.queryOrderById(orderId);
    }
}
