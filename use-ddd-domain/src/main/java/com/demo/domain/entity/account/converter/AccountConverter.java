package com.demo.domain.entity.account.converter;

import com.demo.domain.entity.account.AccountEntity;
import com.demo.domain.entity.base.BaseMapping;
import com.tojaoomy.demo.dataobject.AccountDO;
import org.mapstruct.Mapper;

/**
 * componentModel = spring可以被spring管理
 * @author 玉书
 * @date 2021/2/7
 */
@Mapper(componentModel = "spring")
public interface AccountConverter extends BaseMapping<AccountDO, AccountEntity> {

    @Override
    AccountEntity toDomain(AccountDO dataObject);

    @Override
    AccountDO toDataObject(AccountEntity domain);
}