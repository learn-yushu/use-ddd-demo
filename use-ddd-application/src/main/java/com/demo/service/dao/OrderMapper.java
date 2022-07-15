package com.demo.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.service.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author 玉书
 * @since 2021-12-25
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {

}
