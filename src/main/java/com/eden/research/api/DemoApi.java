package com.eden.research.api;

import com.eden.research.service.IDemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class DemoApi {

    @Resource
    private IDemoService demoService;
    @Value("${demo.config:a}")
    private String config;

    @GetMapping
    public String demo() {
        return demoService.demo();
    }

    @PostConstruct
    private void init() {
        System.out.println("执行初始化 PostConstruct 方法");
        System.out.println("demoService = " + demoService);
        System.out.println("config = " + config);
    }
}
