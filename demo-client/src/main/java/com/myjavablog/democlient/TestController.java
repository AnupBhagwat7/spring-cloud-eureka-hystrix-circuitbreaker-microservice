package com.myjavablog.democlient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo/hello/client")
public class TestController {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping
    public String test(){
        String url = "http://demo-server/demo/hello/server";
        return restTemplate.getForObject(url, String.class);

    }

}
