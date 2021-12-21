package com.tojaoomy.test;

import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.MockConfig;
import com.tojaoomy.payment.app.MainApplication;
import com.tojaoomy.payment.dataobject.OrderComplaintFlowMappingDO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 玉书
 * @date 2021/1/26
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestDataSourceConfig.class, TestMybatisPlusConfiguration.class, MainApplication.class })
public class ApplicationMainTest {

    private static MockConfig mockConfig = new MockConfig()
            // 全局配置
            .globalConfig();



    @Test
    @Ignore
    public void accountExistsTest() {
//        println(accountService.registerAccount(JMockData.mock(RegisterAccountRequest.class)));
    }

    @Test
//    @Sql(statements = "insert into t_order_complaint_flow_mapping (id, deleted, flow_id, flow_detail_id, is_active_flow, flow_status) values  (1, 0, 0, 0, 0, 'init');")
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

    @After
    @Sql(scripts = "h2_sql/delete.sql")
    public void after() {
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

}