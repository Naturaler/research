package com.eden.research.service.impl;

import com.eden.research.service.IDemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoService implements IDemoService {

    @Override
    public String demo() {
        return "hello world";
    }
}
