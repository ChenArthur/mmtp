package com.plus.mmtp.common.config;

import com.plus.mmtp.entity.Permission;
import com.plus.mmtp.entity.User;
import com.plus.mmtp.mapper.PermissionMapper;
import com.plus.mmtp.mapper.UserMapper;
import com.plus.mmtp.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CustomUserService
 * @Description: 自定义UserDetailsService 接口
 * @Auther: ch
 * @Date: 2018/9/25 17:42
 * @Version: 1.0
 **/
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (StringUtils.isEmptyAndNull(userName)) {
            return null;
        }
        User user = this.userMapper.findByUserName(userName);
        if (null != user) {
            List<Permission> permissionList = this.permissionMapper.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissionList) {
                if (null != permission && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
        }
    }
}
