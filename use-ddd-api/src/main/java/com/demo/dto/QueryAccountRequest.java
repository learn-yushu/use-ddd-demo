package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Data
@Builder
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class QueryAccountRequest {

    private String token;

    private Long userId;

    private String userName;

    public static QueryAccountRequest of() {
        return new QueryAccountRequest();
    }
}