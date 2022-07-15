package com.demo.service;

import com.demo.dto.CreateAccountRequest;
import com.demo.vo.AccountVO;

/**
 * @author 玉书
 * @date 2022/7/15
 */
public interface AccountService {

    /**
     * @param accountDto
     */
    boolean createAccount(CreateAccountRequest accountDto);

    /**
     * @param accountId
     * @return
     */
    AccountVO queryAccountById(Long accountId);

    /**
     * @param accountName
     * @return
     */
    AccountVO queryAccountByName(String accountName);
}