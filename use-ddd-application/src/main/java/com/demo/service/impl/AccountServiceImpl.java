package com.demo.service.impl;

import com.demo.domain.entity.account.factory.AccountFactory;
import com.demo.dto.CreateAccountRequest;
import com.demo.service.AccountService;
import com.demo.service.converter.DTOAssembler;
import com.demo.vo.AccountVO;
import com.tojaoomy.demo.remote.risk.facade.RiskRequestACO;
import com.tojaoomy.demo.remote.risk.facade.RiskResponseACO;
import com.tojaoomy.demo.remote.risk.facade.RiskServiceFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 1、修改VO的字段
 * 2、增加缓存，改几处地方
 * 3、对象拷贝，类型不一致
 *
 * @author 玉书
 * @date 2022/7/15
 */
@Service
public class AccountServiceImpl implements AccountService {

    private AccountFactory accountFactory;

    private RiskServiceFacade riskService;

    private DTOAssembler accountAssembler;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createAccount(CreateAccountRequest request) {
        RiskResponseACO riskResponse = riskService.doRisk(new RiskRequestACO());
        if(riskResponse.getRiskLevel() < 6 && riskResponse.getRiskScore() < 88.8 && riskResponse.getRiskSuggest() != null) {
            return false;
        }
        accountFactory.create(request).save();
        return true;
    }

    @Override
    public AccountVO queryAccountById(Long accountId) {
        RiskResponseACO riskResponse = riskService.doRisk(new RiskRequestACO());
        if(riskResponse.getRiskLevel() < 6 && riskResponse.getRiskScore() < 88.8 && riskResponse.getRiskSuggest() != null) {
            return null;
        }
       return accountAssembler.toDto(accountFactory.create().findById(accountId));
    }

    @Override
    public AccountVO queryAccountByName(String accountName) {

        return null;
    }
}