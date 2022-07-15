package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.dto.CreateOrderRequest;
import com.demo.service.OrderService;
import com.demo.service.dao.AccountMapper;
import com.demo.service.dao.OrderMapper;
import com.demo.service.entity.AccountEntity;
import com.demo.service.entity.OrderEntity;
import com.demo.service.remote.RiskService;
import com.demo.service.remote.dto.RiskRequest;
import com.demo.service.remote.dto.RiskResponse;
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

        OrderEntity entity = new OrderEntity();
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
        LambdaQueryWrapper<OrderEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderEntity::getId, orderId);
        Long count = orderMapper.selectCount(queryWrapper);
        if(count > 0) {
            OrderVO orderVO = new OrderVO();
            OrderEntity entity = orderMapper.selectOne(queryWrapper);
            BeanUtils.copyProperties(entity, orderVO);

            //
            LambdaQueryWrapper<AccountEntity> accountWrapper = new LambdaQueryWrapper<>();
            accountWrapper.eq(AccountEntity::getId, entity.getUserId());
            Long userCount = accountMapper.selectCount(accountWrapper);
            if(userCount > 0) {
                AccountVO accountVO = new AccountVO();
                AccountEntity accountEntity = accountMapper.selectOne(accountWrapper);
                orderVO.setUserName(accountEntity.getUserName());
            }
        }
        return null;
    }
}