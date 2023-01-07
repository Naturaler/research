package com.eden.research.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class DemoComponent {
    @Value("${property.config}")
    private String configFromProperty;
    @Value("${default.config:whatever}")
    private String defaultConfig;
    private String constructorConfig;

    public DemoComponent(@Value("${constructor.config:java}") String constructorConfig) {
        this.constructorConfig = constructorConfig;
    }

    @PostConstruct
    private void demo() {
        log.info("configFromProperty: {}", configFromProperty);
        log.info("defaultConfig: {}", defaultConfig);
        log.info("constructorConfig: {}", constructorConfig);
    }
}
