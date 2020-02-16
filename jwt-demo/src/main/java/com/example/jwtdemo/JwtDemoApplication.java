package com.example.jwtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class JwtDemoApplication {

    @RequestMapping(value = "/hi" , method = RequestMethod.GET)
    public String hi() {
        return "Hi";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("Processing Request "+new Date());
        return "Hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }

}
