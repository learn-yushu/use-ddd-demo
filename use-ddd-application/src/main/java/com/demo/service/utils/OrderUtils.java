package com.demo.service.utils;

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
public class OrderUtils {

    public static boolean equal(BigDecimal productPrice, Long count, BigDecimal totalPrice) {
        if(totalPrice.equals(productPrice.multiply(BigDecimal.valueOf(count)))) {
            return true;
        }
        return false;
    }
}