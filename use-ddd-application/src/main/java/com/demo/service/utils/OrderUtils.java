package com.demo.service.utils;

import java.math.BigDecimal;

/**
 * @author 玉书
 * @date 2022/7/15
 */
public class OrderUtils {

    public static boolean equal(BigDecimal productPrice, Long count, BigDecimal totalPrice) {
        if(totalPrice.equals(productPrice.multiply(BigDecimal.valueOf(count)))) {
            return true;
        }
        return false;
    }
}