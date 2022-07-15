package com.demo.domain.entity.account.factory;

import com.demo.domain.entity.account.AccountEntity;
import com.demo.domain.entity.account.repository.AccountRepository;
import com.demo.dto.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Component
public class AccountFactory {

    @Autowired
    private AccountRepository accountRepository;

    public AccountEntity create(CreateAccountRequest request) {
        return AccountEntity.builder()
                .address(request.getAddress())
                .age(request.getAge().toString())
                .accountRepository(accountRepository)
                .build();
    }

    public AccountEntity create() {
        return AccountEntity.builder()
                .accountRepository(accountRepository)
                .build();
    }
}