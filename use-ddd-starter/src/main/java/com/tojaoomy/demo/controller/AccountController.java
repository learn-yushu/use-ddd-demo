package com.tojaoomy.demo.controller;

import com.demo.dto.CreateAccountRequest;
import com.demo.service.AccountService;
import com.demo.vo.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 * @date 2021/12/20
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @RequestMapping("/create")
    public boolean createAccount(CreateAccountRequest accountDto) {
        return accountService.createAccount(accountDto);
    }

    @RequestMapping("/queryById")
    public AccountVO queryAccountById(Long accountId) {
        return accountService.queryAccountById(accountId);
    }

    @RequestMapping("/queryByName")
    public AccountVO queryAccountByName(String accountName) {
        return accountService.queryAccountByName(accountName);
    }
}
