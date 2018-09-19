package com.plus.mmtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
