package com.tojaoomy.payment.mapper;

import com.tojaoomy.payment.dataobject.OrderComplaintItemDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 支付订单补单工作流明细 Mapper 接口
 * </p>
 *
 * @author 松梁
 * @since 2021-12-21
 */
@Mapper
public interface OrderComplaintItemMapper extends BaseMapper<OrderComplaintItemDO> {

}
