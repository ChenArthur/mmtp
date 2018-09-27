package com.plus.mmtp.mapper;

import com.plus.mmtp.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ch
 * @since 2018-09-25
 */
public interface UserMapper extends BaseMapper<User> {

    User findByUserName(@Param("username") String userName);
}
