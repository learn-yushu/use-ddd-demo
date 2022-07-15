package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.dto.CreateOrderRequest;
import com.demo.service.OrderService;
import com.tojaoomy.demo.dataobject.AccountDO;
import com.tojaoomy.demo.dataobject.OrderDO;
import com.tojaoomy.demo.mapper.AccountMapper;
import com.tojaoomy.demo.mapper.OrderMapper;
import com.tojaoomy.demo.remote.risk.api.RiskService;
import com.tojaoomy.demo.remote.risk.api.RiskRequest;
import com.tojaoomy.demo.remote.risk.api.RiskResponse;
import com.demo.service.utils.MobileUtils;
import com.demo.service.utils.OrderUtils;
import com.demo.vo.AccountVO;
import com.demo.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 使用缓存怎么办
 * @author 玉书
 * @date 2022/7/15
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    private AccountMapper accountMapper;

    private RiskService riskService;

    @Override
    public boolean createOrder(CreateOrderRequest orderDto) {
        RiskResponse riskResponse = riskService.doRisk(new RiskRequest());
        if(riskResponse.getRisk_level() < 6 && riskResponse.getRisk_score() < 88.8 && riskResponse.getRisk_suggest() != null) {
            return false;
        }
        if(!MobileUtils.validate(orderDto.getMobileNumber())) {
            return false;
        }
        if(!OrderUtils.equal(orderDto.getProductPrice(), orderDto.getCount(), orderDto.getTotalPrice())) {
            return false;
        }

        OrderDO entity = new OrderDO();
        BeanUtils.copyProperties(orderDto, entity);
        orderMapper.insert(entity);
        return true;
    }

    @Override
    public OrderVO queryOrderById(Long orderId) {
        RiskResponse riskResponse = riskService.doRisk(new RiskRequest());
        if(riskResponse.getRisk_level() < 6 && riskResponse.getRisk_score() < 88.8 && riskResponse.getRisk_suggest() != null) {
            return null;
        }
        LambdaQueryWrapper<OrderDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDO::getId, orderId);
        Long count = orderMapper.selectCount(queryWrapper);
        if(count > 0) {
            OrderVO orderVO = new OrderVO();
            OrderDO entity = orderMapper.selectOne(queryWrapper);
            BeanUtils.copyProperties(entity, orderVO);

            //
            LambdaQueryWrapper<AccountDO> accountWrapper = new LambdaQueryWrapper<>();
            accountWrapper.eq(AccountDO::getId, entity.getUserId());
            Long userCount = accountMapper.selectCount(accountWrapper);
            if(userCount > 0) {
                AccountDO AccountDO = accountMapper.selectOne(accountWrapper);
                orderVO.setUserName(AccountDO.getUserName());
            }
        }
        return null;
    }
}