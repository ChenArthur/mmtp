package com.plus.mmtp.service.impl;

import com.plus.mmtp.entity.User;
import com.plus.mmtp.mapper.UserMapper;
import com.plus.mmtp.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ch
 * @since 2018-09-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
