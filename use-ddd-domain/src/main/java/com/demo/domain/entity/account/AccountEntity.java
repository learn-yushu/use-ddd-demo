package com.demo.domain.entity.account;

import com.demo.domain.entity.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Data
@Builder
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class AccountEntity {

    private String userName;

    private String age;

    private String mobile;

    private String address;

    private String email;

    private String birthDate;

    private AccountRepository accountRepository;

    public boolean isValidBirthDate(String birthday) {
        return true;
    }


    public boolean validateEmail(String email) {
        if(email == null) {
            return false;
        }
        //判断email的格式是否正确
        return true;
    }

    private boolean validateMobile(String mobileNumber) {
        if(mobileNumber == null) {
            return false;
        }
        if(!mobileNumber.startsWith("1")) {
            return false;
        }
        // 判断 手机号码 和座机

        return true;
    }

    private void check() {
        validateEmail(email);
        validateMobile(mobile);
        isValidBirthDate(birthDate);
    }

    public void save() {
        check();
        accountRepository.save(this);
    }

    public AccountEntity findById(Long id) {
        return accountRepository.findById(id);
    }
}