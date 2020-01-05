package com.example.timeserviceclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import java.net.URI;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class TimeserviceClientApplication {

    @Autowired
    ServiceBean serviceBean;

    @RequestMapping("/time")
    public String todayTime(){
        return serviceBean.getTime();
    }

    public static void main(String[] args) {
        SpringApplication.run(TimeserviceClientApplication.class, args);
    }


}
