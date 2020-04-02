package com.example.authapiserver;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HelloService {

    @GetMapping("/api/hi")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public Map<String,String> hi(){
        return new HashMap<String,String>(){{
            this.put("message","Hi User");
        }};
    }
}
