package com.tojaoomy.demo.remote.risk.facade;

import com.tojaoomy.demo.remote.risk.api.RiskRequest;
import com.tojaoomy.demo.remote.risk.api.RiskResponse;
import com.tojaoomy.demo.remote.risk.api.RiskService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Service
public class RiskServiceFacade implements RiskService {

    private RestTemplate restTemplate;

    @Override
    public RiskResponse doRisk(RiskRequest request) {
        //risk_score -> riskScore;
        RiskResponse forObject = restTemplate.getForObject("", null);
        return forObject;
    }
}