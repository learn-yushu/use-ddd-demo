package com.tojaoomy.demo.remote.risk.converter;

import com.tojaoomy.demo.remote.risk.api.RiskRequest;
import com.tojaoomy.demo.remote.risk.facade.RiskRequestACO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Mapper(componentModel = "spring")
public interface RiskAdaptor {

    @Mapping(source = "timestamp", target = "ts")
    RiskRequest toDto(RiskRequestACO aco);
}