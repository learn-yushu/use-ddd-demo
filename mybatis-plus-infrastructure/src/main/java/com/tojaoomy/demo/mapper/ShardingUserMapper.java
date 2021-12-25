package com.tojaoomy.demo.mapper;

import com.tojaoomy.demo.dataobject.ShardingUserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 玉书
 * @since 2021-12-25
 */
@Mapper
public interface ShardingUserMapper extends BaseMapper<ShardingUserDO> {

}
