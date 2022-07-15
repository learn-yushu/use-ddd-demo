package com.tojaoomy.demo.remote.risk.facade;

import com.tojaoomy.demo.remote.risk.api.RiskResponse;
import com.tojaoomy.demo.remote.risk.api.RiskService;
import com.tojaoomy.demo.remote.risk.converter.RiskAdaptor;
import com.tojaoomy.demo.remote.risk.converter.RiskTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Service
public class RiskServiceFacade {

    @Resource
    private RiskService riskService;

    @Autowired
    private RiskAdaptor riskAdaptor;

    @Autowired
    private RiskTranslator riskTranslator;

    private boolean mock;

    public RiskResponseACO doRisk(RiskRequestACO request) {
        if(mock) {
            return new RiskResponseACO().setCode("success").setRiskLevel(10);
        } else {
            RiskResponse riskResponse = riskService.doRisk(riskAdaptor.toDto(request));
            // 降级逻辑 ， Mock 服务

            return riskTranslator.toAco(riskResponse);
        }
    }
}