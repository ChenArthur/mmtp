package com.plus.mmtp.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * @ClassName: ResourceUrlProviderController
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/8/31 14:53
 * @Version: 1.0
 **/
@ControllerAdvice
public class ResourceUrlProviderController {

    @Autowired
    public ResourceUrlProvider resourceUrlProvider;

    @ModelAttribute("urls")
    public ResourceUrlProvider urls(){
        return this.resourceUrlProvider;
    }
}
