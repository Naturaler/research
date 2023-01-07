package com.eden.research.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoApi {
    @Value("${demo.config:a|b|c}")
    private List<String> config;

    @GetMapping
    public String demo(@Value("${method.config:html}") String methodConfig) {
        log.info("methodConfig: {}", methodConfig);
        return "hello world";
    }

    @PostConstruct
    private void init() {
        log.info("config: {}", config);
    }
}
