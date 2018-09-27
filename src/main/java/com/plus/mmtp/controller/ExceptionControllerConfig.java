package com.plus.mmtp.controller;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @ClassName: ExceptionControllerConfig
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/9/27 10:57
 * @Version: 1.0
 **/
public class ExceptionControllerConfig {
    private final ServerProperties serverProperties;

    private final List<ErrorViewResolver> errorViewResolvers;

    public ExceptionControllerConfig(ServerProperties serverProperties, ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
        this.serverProperties = serverProperties;
        this.errorViewResolvers = errorViewResolversProvider.getIfAvailable();
    }

    /*@Bean
    public ExceptionController exceptionController(ErrorAttributes errorAttributes) {
        return new ExceptionController(errorAttributes, this.serverProperties.getError(), this.errorViewResolvers);
    }*/
}
