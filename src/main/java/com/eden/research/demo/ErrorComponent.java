package com.eden.research.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class ErrorComponent {
    @Value("${non.config}")
    private String emptyConfig;
}
