package com.example.myrestfulservice.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(path="/hello-bean")
    public HelloBean helloBean(){
        return new HelloBean("Hello Bean!");
    }

    @GetMapping(path="/path/{name}")
    public HelloBean path(@PathVariable String name){
        return new HelloBean(String.format("hello world %s", name));
    }
}
