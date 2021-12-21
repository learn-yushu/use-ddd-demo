package com.tojaoomy.payment.app;


import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * sharding-jdbc分片策略
 *
 * @author hejian
 */
public class TransactionIdStrategyAlgorithm implements PreciseShardingAlgorithm<String> {

    private final static String LOGIC_OTHTER_TABLE = "xy_iap_receipt_verify_transaction_x";

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        String transactionStr = shardingValue.getValue();
        String tableShardingMark = transactionStr.substring(transactionStr.length() - 1);

        for (String targetName : availableTargetNames) {
            if (targetName.endsWith(tableShardingMark)) {
                return targetName;
            }
        }
        return LOGIC_OTHTER_TABLE;
    }

}
