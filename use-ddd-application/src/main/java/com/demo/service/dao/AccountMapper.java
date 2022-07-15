package com.demo.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tojaoomy.demo.dataobject.AccountEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author 玉书
 * @since 2021-12-25
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountEntity> {

}
