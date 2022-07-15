package com.tojaoomy.demo.remote.risk.converter;

import com.tojaoomy.demo.remote.risk.api.RiskResponse;
import com.tojaoomy.demo.remote.risk.facade.RiskResponseACO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Mapper(componentModel = "spring")
public interface RiskTranslator {

    @Mapping(source = "risk_level", target = "riskLevel")
    @Mapping(source = "risk_suggest", target = "riskSuggest")
    @Mapping(source = "risk_score", target = "riskScore")
    RiskResponseACO toAco(RiskResponse riskResponse);
}