package com.demo.service.impl;

import com.demo.domain.entity.order.factory.OrderFactory;
import com.demo.dto.CreateOrderRequest;
import com.demo.service.OrderService;
import com.demo.service.converter.DTOAssembler;
import com.demo.vo.OrderVO;
import com.tojaoomy.demo.remote.risk.facade.RiskRequestACO;
import com.tojaoomy.demo.remote.risk.facade.RiskResponseACO;
import com.tojaoomy.demo.remote.risk.facade.RiskServiceFacade;
import org.springframework.stereotype.Service;

/**
 * 使用缓存怎么办
 * @author 玉书
 * @date 2022/7/15
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderFactory orderFactory;

    private RiskServiceFacade riskService;

    private DTOAssembler dtoAssembler;

    @Override
    public boolean createOrder(CreateOrderRequest request) {
        RiskResponseACO riskResponse = riskService.doRisk(new RiskRequestACO());
        if(riskResponse.getRiskLevel() < 6 && riskResponse.getRiskScore() < 88.8 && riskResponse.getRiskSuggest() != null) {
            return false;
        }
        orderFactory.create(request).save();
        return true;
    }

    @Override
    public OrderVO queryOrderById(Long orderId) {
        RiskResponseACO riskResponse = riskService.doRisk(new RiskRequestACO());
        if(riskResponse.getRiskLevel() < 6 && riskResponse.getRiskScore() < 88.8 && riskResponse.getRiskSuggest() != null) {
            return null;
        }
        return dtoAssembler.toDto(orderFactory.create().findById());
    }
}