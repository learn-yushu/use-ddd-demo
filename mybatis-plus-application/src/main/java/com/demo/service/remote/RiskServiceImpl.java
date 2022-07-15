package com.demo.service.remote;

import com.demo.service.remote.dto.RiskRequest;
import com.demo.service.remote.dto.RiskResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Service
public class RiskServiceImpl implements RiskService {

    private RestTemplate restTemplate;

    @Override
    public RiskResponse doRisk(RiskRequest request) {
        //risk_score -> riskScore;
        RiskResponse forObject = restTemplate.getForObject("", null);
        return forObject;
    }
}