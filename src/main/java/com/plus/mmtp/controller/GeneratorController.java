package com.plus.mmtp.controller;

import com.plus.mmtp.common.MysqlGenerator;
import com.plus.mmtp.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ClassName: GeneratorController
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/9/19 14:32
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/generator")
public class GeneratorController {

    @GetMapping("/index")
    public String generatorPage(){
        return "tablepage/generator";
    }

    @GetMapping("/")
    public String execute(Map<String, Object> params){
        String str = "";
        if (StringUtils.isEmptyAndNull(params.get("author"))) {
            str = "传入参数‘作者’为空！";
            return str;
        }
        MysqlGenerator.Gennerator(params);
        return str;
    }
}
