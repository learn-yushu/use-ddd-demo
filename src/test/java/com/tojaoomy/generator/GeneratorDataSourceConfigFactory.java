package com.tojaoomy.generator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 玉书
 * @date 2021/12/20
 */
@Data
@Builder
@AllArgsConstructor
@Accessors(chain = true)
public class GeneratorDataSourceConfigFactory {

    public static GeneratorDataSourceConfig createSdk() {
        return GeneratorDataSourceConfig.builder()
                .dataSourceSchema("sdk")
                .dataSourceIp("172.16.33.205")
                .dataSourcePort(3307)
                .username("game_admin")
                .password("bHYACbxgM2gWHnF6Il1nX8VnNEfb51KY")
                .build();
    }

    public static GeneratorDataSourceConfig createCompliant() {
        return GeneratorDataSourceConfig.builder()
                .dataSourceSchema("sdk_hot_deploy")
                .dataSourceIp("10.221.32.12")
                .dataSourcePort(5223)
                .username("sdk_hot_deploy")
                .password("xPlahCMf1sKr2ZKsj6GIpsXG8C6Bd3AM")
                .prefixes(new String[]{"t_"})
                .build();
    }

    public static GeneratorDataSourceConfigFactory of() {
        return new GeneratorDataSourceConfigFactory();
    }
}