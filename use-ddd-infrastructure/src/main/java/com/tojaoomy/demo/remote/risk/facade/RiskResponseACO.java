package com.tojaoomy.demo.remote.risk.facade;

import lombok.Data;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Data
public class RiskResponseACO {

    private String code;

    private String message;

    /**
     * 风控等级
     */
    private long riskLevel;

    /**
     * 建议
     */
    private String riskSuggest;

    private Double riskScore;

}