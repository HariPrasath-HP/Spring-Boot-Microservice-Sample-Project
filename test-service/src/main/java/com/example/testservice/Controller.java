package com.example.testservice;

import com.example.testservice.shared.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {
    @Autowired
    Configuration configuration;
    @GetMapping("/properties")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
        LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMin(),
                configuration.getMax());
        return limitConfiguration;
    }
}
