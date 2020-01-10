package com.myjavablog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/hello/server")
public class HelloController {

    @GetMapping
    public String message(){
        return "Hello from MyJavaBlog";
    }

}
