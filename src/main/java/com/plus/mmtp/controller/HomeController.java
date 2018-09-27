package com.plus.mmtp.controller;

import com.plus.mmtp.entity.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: HomeController
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/8/31 11:32
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/homepage")
    public String homePage(){
        return "home";
    }

    @GetMapping("/loginpage")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/demopage")
    public String demoPage(){
        return "demo";
    }

    @GetMapping("/indexpage")
    public String indexPage(){
        return "index";
    }

    /*@GetMapping("/index")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
        model.addAttribute("msg", msg);
        return "home";
    }*/

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "security/index";
    }

    @GetMapping("/user/index")
    public String userIndex() {
        return "security/user/index";
    }

    @GetMapping("/login")
    public String login(){
        return "security/login2";
    }

    @GetMapping("/loginError")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "security/login2";
    }
}
