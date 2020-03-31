package com.example.authapiserver;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyAuthenticationEntrypoint implements AuthenticationEntryPoint {

    private final HttpMessageConverter<String> messageConverter;
    private final ObjectMapper mapper;

    public MyAuthenticationEntrypoint(ObjectMapper mapper) {
        this.messageConverter=new StringHttpMessageConverter();
        this.mapper=mapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Map<String,String> myError=new HashMap<String,String>(){{
            put("message",authException.getMessage());
        }};

        ServerHttpResponse outputMessage=new ServletServerHttpResponse(response);
        outputMessage.setStatusCode(HttpStatus.UNAUTHORIZED);

        messageConverter.write(mapper.writeValueAsString(myError), MediaType.APPLICATION_JSON,outputMessage);

    }
}
