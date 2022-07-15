package com.demo.service.v2.impl;

import com.demo.dto.CreateAccountRequest;
import com.demo.dto.QueryAccountRequest;
import com.demo.service.v2.V2AccountService;
import com.demo.vo.AccountVO;
import org.springframework.stereotype.Service;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Service
public class V2AccountServiceImpl implements V2AccountService {

    @Override
    public void createAccount(CreateAccountRequest accountDto) {

    }

    @Override
    public AccountVO queryAccount(QueryAccountRequest queryAccountRequest) {
        return null;
    }

}