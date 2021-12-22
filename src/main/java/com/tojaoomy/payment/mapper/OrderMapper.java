package com.tojaoomy.payment.mapper;

import com.tojaoomy.payment.dataobject.OrderDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 支付订单补单工作流映射表 Mapper 接口
 * </p>
 *
 * @author 玉书
 * @since 2021-12-22
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {

}
