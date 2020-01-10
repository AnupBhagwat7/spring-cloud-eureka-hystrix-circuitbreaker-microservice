package com.myjavablog.democlient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
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
    @HystrixCommand(fallbackMethod = "handleFallback")
    public String test(){
        String url = "http://demo-server/demo/hello/server";
        return restTemplate.getForObject(url, String.class);
    }

    public String handleFallback(){
        return "Fallback hello service";
    }
}
