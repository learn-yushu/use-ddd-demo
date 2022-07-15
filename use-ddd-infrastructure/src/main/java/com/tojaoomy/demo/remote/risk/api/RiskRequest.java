package com.tojaoomy.demo.remote.risk.api;

import lombok.Data;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Data
public class RiskRequest {

    private String userId;

    private String appId;

    private Long ts;

    private String secretKey;

    private String sign;

}