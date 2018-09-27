package com.plus.mmtp.mapper;

import com.plus.mmtp.entity.Permission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ch
 * @since 2018-09-25
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> findAll();

    List<Permission> findByAdminUserId(Integer userId);
}
