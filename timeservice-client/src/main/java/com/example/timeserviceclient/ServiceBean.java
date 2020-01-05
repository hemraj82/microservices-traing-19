package com.example.timeserviceclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class ServiceBean {


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "fallBackResponse")
    public String getTime() {
        URI uri= URI.create("http://localhost:8080/time-service");
        return "Time Service Client Response : "+this.restTemplate.getForObject(uri,String.class);
    }


    public String fallBackResponse(){
        return "Today time is not avaialble";
    }
}
