package com.example.helloservices;

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

    @RequestMapping("/")
    public Map<String, String> hello(){
        Map<String,String> response=new HashMap(){{
            this.put("status","Ok");
            this.put("message","hello user");

        }};
        return response;
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloServicesApplication.class, args);
    }

}
