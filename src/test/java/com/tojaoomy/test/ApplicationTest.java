package com.tojaoomy.test;

import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.MockConfig;
import com.tojaoomy.payment.app.MainApplication;
import com.tojaoomy.payment.dataobject.OrderComplaintFlowMappingDO;
import com.tojaoomy.payment.dataobject.OrderDO;
import com.tojaoomy.payment.dataobject.ShardingUserDO;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author 玉书
 * @date 2021/1/26
 */
@SpringBootTest
//@ActiveProfiles("test")
//@Sql(scripts = "/h2_sql/delete.sql")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestDataSourceConfig.class, TestMybatisPlusConfiguration.class })
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class }, scanBasePackages = {"com.tojaoomy.payment"})
public class ApplicationTest {

    private static MockConfig mockConfig = new MockConfig()
            // 全局配置
            .globalConfig();

    @Test
    @Ignore
    public void accountExistsTest() {
//        println(accountService.registerAccount(JMockData.mock(RegisterAccountRequest.class)));
    }

    @Test
    @Sql(statements = "insert into t_order_complaint_flow_mapping (id, deleted, flow_id, flow_detail_id, is_active_flow, flow_status) values  (10, 0, 0, 0, 0, 'init');")
    public void testSqlInsert() {

    }

    /**
     * 测试乐观锁
     */
    @Test
    public void testVersion() {
        OrderDO orderDO = new OrderDO();
        orderDO.selectById(1).setOrderId("1234").updateById();
    }

    @Test
    public void testSharding() {
        for (int i = 0; i < 100; i++) {
            ShardingUserDO shardingUserDO = new ShardingUserDO();
            shardingUserDO.setUserId("123" + i);
            shardingUserDO.insert();
        }
    }

    @Test
    public void configMapper_selectByExample() {
        OrderComplaintFlowMappingDO orderComplaintFlowMappingDO = new OrderComplaintFlowMappingDO();
        printJSON(orderComplaintFlowMappingDO.selectAll());
        orderComplaintFlowMappingDO.setFlowId(1L);
        orderComplaintFlowMappingDO.insert();
        printJSON(orderComplaintFlowMappingDO.selectById(orderComplaintFlowMappingDO.getId()));

        orderComplaintFlowMappingDO.setFlowStatus("approved").updateById();
        printJSON(orderComplaintFlowMappingDO.selectById(orderComplaintFlowMappingDO.getId()));
    }

    private static void printJSON(Object object) {
        System.out.println(JSON.toJSONString(object, true));
    }

    @BeforeEach
    public void after() {
        System.out.println("before !!!");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("after class");
    }

}