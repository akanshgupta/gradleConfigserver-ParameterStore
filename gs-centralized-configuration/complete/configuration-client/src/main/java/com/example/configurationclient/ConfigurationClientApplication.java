package com.example.configurationclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigurationClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationClientApplication.class, args);
    }
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${message}")
    private String message;
    
    @Value("${localtest}")
    private String myconfig;

    @RequestMapping("/local")
    String getLocalMessage() {
        return this.myconfig;
    }

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}
