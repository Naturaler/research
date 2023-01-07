package com.eden.research.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class ValueConverterComponent {
    @Value("${list.converter:a,b,c}")
    private List<String> list;
    @Value("${set.converter:a,b,c}")
    private Set<String> set;
    @Value("${map.converter:k1:v1,k2:v2}")
    private Map<String, String> map;

    @PostConstruct
    private void converter() {
        log.info("list: {}", list);
        log.info("set: {}", set);
        log.info("map: {}", map);
    }
}
