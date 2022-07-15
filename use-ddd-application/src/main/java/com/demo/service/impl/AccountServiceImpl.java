package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.dto.CreateAccountRequest;
import com.demo.service.AccountService;
import com.tojaoomy.demo.dataobject.AccountDO;
import com.tojaoomy.demo.mapper.AccountMapper;
import com.tojaoomy.demo.remote.risk.api.RiskService;
import com.tojaoomy.demo.remote.risk.api.RiskRequest;
import com.tojaoomy.demo.remote.risk.api.RiskResponse;
import com.demo.service.utils.DateUtils;
import com.demo.service.utils.EmailUtils;
import com.demo.service.utils.MobileUtils;
import com.demo.vo.AccountVO;
import org.springframework.beans.BeanUtils;
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

    private AccountMapper accountMapper;

    private RiskService riskService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createAccount(CreateAccountRequest accountDto) {
        RiskResponse riskResponse = riskService.doRisk(new RiskRequest());
        if(riskResponse.getRisk_level() < 6 && riskResponse.getRisk_score() < 88.8 && riskResponse.getRisk_suggest() != null) {
            return false;
        }
        if(!MobileUtils.validate(accountDto.getMobile())) {
            return false;
        }
        if(!EmailUtils.validate(accountDto.getEmail())) {
            return false;
        }
        if(!DateUtils.isValidDate(accountDto.getBirthDate())) {
            return false;
        }
        LambdaQueryWrapper<AccountDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AccountDO::getUserName, accountDto.getUserName());
        Long count = accountMapper.selectCount(queryWrapper);
        if(count > 0) {
            return false;
        }

        AccountDO entity = new AccountDO();
        //AccountDO age = String , CreateAccountRequest age = Long
        // 会有什么问题？
        BeanUtils.copyProperties(accountDto, entity);
        accountMapper.insert(entity);
        return true;
    }

    @Override
    public AccountVO queryAccountById(Long accountId) {
        RiskResponse riskResponse = riskService.doRisk(new RiskRequest());
        if(riskResponse.getRisk_level() < 6 && riskResponse.getRisk_score() < 88.8 && riskResponse.getRisk_suggest() != null) {
            return null;
        }
        LambdaQueryWrapper<AccountDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AccountDO::getId, accountId);
        Long count = accountMapper.selectCount(queryWrapper);
        if(count > 0) {
            AccountVO accountVO = new AccountVO();
            AccountDO entity = accountMapper.selectOne(queryWrapper);
            BeanUtils.copyProperties(entity, accountVO);
            //如果要加缓存呢？
        }
        return null;
    }

    @Override
    public AccountVO queryAccountByName(String accountName) {
        RiskResponse riskResponse = riskService.doRisk(new RiskRequest());
        if(riskResponse.getRisk_level() < 6 && riskResponse.getRisk_score() < 88.8 && riskResponse.getRisk_suggest() != null) {
            return null;
        }
        LambdaQueryWrapper<AccountDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AccountDO::getUserName, accountName);
        Long count = accountMapper.selectCount(queryWrapper);
        if(count > 0) {
            AccountVO accountVO = new AccountVO();
            AccountDO entity = accountMapper.selectOne(queryWrapper);
            BeanUtils.copyProperties(entity, accountVO);
            //如果要加缓存呢？

        }
        return null;
    }
}