package com.tojaoomy.demo.remote.risk.api;


import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@FeignClient()
public interface RiskService {

    RiskResponse doRisk(RiskRequest request);
}