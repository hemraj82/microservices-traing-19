package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class HiServiceApplication {

	@RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String, String> hello(){
		Map<String,String> response=new HashMap(){{
			this.put("status","Ok");
			this.put("message","Hi service is running. "+new Date());

		}};
		return response;
	}
	@RequestMapping(value = "/hi",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String, String> hi(){
		Map<String,String> response=new HashMap(){{
			this.put("status","Ok");
			this.put("message","Hi 2 service is running. "+new Date());

		}};
		return response;
	}
	public static void main(String[] args) {
		SpringApplication.run(HiServiceApplication.class, args);
	}

}
