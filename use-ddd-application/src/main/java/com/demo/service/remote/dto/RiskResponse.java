package com.demo.service.remote.dto;

import lombok.Data;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Data
public class RiskResponse {

    private String code;

    private String message;

    /**
     * 风控等级
     */
    private long risk_level;

    /**
     * 建议
     */
    private String risk_suggest;

    private Double risk_score;

}