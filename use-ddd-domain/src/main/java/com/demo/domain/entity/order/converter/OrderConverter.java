package com.demo.domain.entity.order.converter;

import com.demo.domain.entity.base.BaseMapping;
import com.demo.domain.entity.order.OrderEntity;
import com.tojaoomy.demo.dataobject.OrderDO;
import org.mapstruct.Mapper;

/**
 * componentModel = spring可以被spring管理
 * @author 玉书
 * @date 2021/2/7
 */
@Mapper(componentModel = "spring")
public interface OrderConverter extends BaseMapping<OrderDO, OrderEntity> {

    @Override
    OrderEntity toDomain(OrderDO dataObject);

    @Override
    OrderDO toDataObject(OrderEntity domain);
}