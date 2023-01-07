package com.eden.research.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
public class MyConverterListener implements SpringApplicationRunListener {
    public MyConverterListener(SpringApplication application, String[] args) {

    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        log.info("加载自定义listener");
        ConfigurableConversionService conversionService = environment.getConversionService();
        conversionService.addConverter(new StringToMapConverter());
    }

}
