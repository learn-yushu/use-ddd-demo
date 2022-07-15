package com.demo.service.v2;

import com.demo.dto.CreateAccountRequest;
import com.demo.dto.QueryAccountRequest;
import com.demo.vo.AccountVO;

/**
 * @author 玉书
 * @date 2022/7/15
 */
public interface V2AccountService {

    /**
     * @param accountDto
     */
    void createAccount(CreateAccountRequest accountDto);

    /**
     * @param queryAccountRequest
     * @return
     */
    AccountVO queryAccount(QueryAccountRequest queryAccountRequest);

}