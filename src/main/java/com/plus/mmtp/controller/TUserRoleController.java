package com.plus.mmtp.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.plus.mmtp.entity.TUserRole;
import com.plus.mmtp.service.TUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.plus.mmtp.base.AbstractController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ch
 * @since 2018-07-16
 */
@RestController
@RequestMapping("/tUserRole")
public class TUserRoleController extends AbstractController {

    @Autowired
    TUserRoleService tUserRoleService;

    @GetMapping("/test")
    public Page<TUserRole> test(){
        return tUserRoleService.selectPage(new Page<TUserRole>(0, 12));
    }

    @GetMapping("/insert")
    public void insert(){
        TUserRole userRole = new TUserRole();
        userRole.setId(123);
        userRole.setCreateTime(new Date());
        userRole.setMark("success");
        userRole.setRole("USER");
        tUserRoleService.insert(userRole);
    }
}

