package com.example.helloservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class HelloServicesApplication {

    @Value("${spring.application.name}")
    String m;

    @RequestMapping("/hi")
    public Map<String, String> hello(){
        Map<String,String> response=new HashMap(){{
            this.put("status","Ok");
            this.put("message",m);

        }};
        return response;
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloServicesApplication.class, args);
    }

}
