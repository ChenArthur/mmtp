package com.plus.mmtp.controller;


import com.plus.mmtp.entity.User;
import com.plus.mmtp.mapper.UserMapper;
import com.plus.mmtp.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.plus.mmtp.base.AbstractController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ch
 * @since 2018-09-25
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/register")
    public String registerPage(){
        return "security/register";
    }

    @PostMapping("/addorupdateuser")
    @ResponseBody
    public JsonResult addOrUpdateUser(User user){
        String msg = "";
        if (null != user) {
            if (user.getId() != null) {
                this.userMapper.updateById(user);
                msg = "更新成功！";
            } else {
                if (user.getPassword() != null) {
                    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                    user.setPassword(encoder.encode(user.getPassword()));
                    this.userMapper.insert(user);
                    msg = "添加成功！";
                } else {
                    System.out.println("***************************");
                    msg = "添加失败！";
                }
            }
        } else {
            System.out.println("----------------------------");
            msg = "参数错误！";
        }
        return new JsonResult(msg);
    }
}

