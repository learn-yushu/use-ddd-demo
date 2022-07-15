package com.demo.service.converter;

import com.demo.domain.entity.account.AccountEntity;
import com.demo.domain.entity.order.OrderEntity;
import com.demo.vo.AccountVO;
import com.demo.vo.OrderVO;
import org.mapstruct.Mapper;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Mapper(componentModel = "spring")
public interface DTOAssembler {

    AccountVO toDto(AccountEntity entity);

    OrderVO toDto(OrderEntity entity);
}