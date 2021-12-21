package com.tojaoomy.payment.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tojaoomy.payment.dataobject.OrderComplaintFlowMappingDO;
import com.tojaoomy.payment.mapper.OrderComplaintFlowMappingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 * @date 2021/12/20
 */
@Slf4j
@RestController
@RequestMapping("/mapping")
public class MappingController {

    @Autowired
    private OrderComplaintFlowMappingMapper mappingMapper;

    @RequestMapping("/counts")
    public Long getCount() {
        LambdaQueryWrapper<OrderComplaintFlowMappingDO> wrapper = new LambdaQueryWrapper<OrderComplaintFlowMappingDO>()
                .eq(OrderComplaintFlowMappingDO::getDeleted, 0);
        return mappingMapper.selectCount(wrapper);
    }
}
