package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Data
@Builder
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class CreateOrderRequest {

    private String token;

    private String productName;

    private BigDecimal productPrice;

    private Long count;

    private BigDecimal totalPrice;

    private String address;

    private String mobileNumber;

    private Long userId;

}