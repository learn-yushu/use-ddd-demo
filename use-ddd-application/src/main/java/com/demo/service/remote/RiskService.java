package com.demo.service.remote;

import com.demo.service.remote.dto.RiskRequest;
import com.demo.service.remote.dto.RiskResponse;

/**
 * @author 玉书
 * @date 2022/7/15
 */
public interface RiskService {

    RiskResponse doRisk(RiskRequest request);
}