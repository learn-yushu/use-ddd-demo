package com.demo.domain.entity.account.repository;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.domain.entity.account.AccountEntity;
import com.demo.domain.entity.account.converter.AccountConverter;
import com.tojaoomy.demo.cache.api.CacheService;
import com.tojaoomy.demo.dataobject.AccountDO;
import com.tojaoomy.demo.mapper.AccountMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Component
public class AccountRepository {

    @Autowired
    private AccountConverter accountConverter;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CacheService cacheService;

    public void save(AccountEntity entity) {
        accountMapper.insert(accountConverter.toDataObject(entity));
    }

    public AccountEntity findById(Long accountId) {
        String value = cacheService.get(accountId.toString());
        if(StringUtils.isNotBlank(value)) {
            return JSON.parseObject(value, AccountEntity.class);
        }

        LambdaQueryWrapper<AccountDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AccountDO::getId, accountId);
        AccountDO accountDO = accountMapper.selectOne(queryWrapper);
        AccountEntity entity = accountConverter.toDomain(accountDO);

        cacheService.put(accountId.toString(), JSON.toJSONString(entity));
        return entity;
    }

}