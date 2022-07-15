package com.tojaoomy.demo.remote.risk.facade;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Data
@Builder
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class RiskRequestACO {

    private String userId;

    private String appId;

    private Long timestamp;

    private String secretKey;

    private String sign;
}