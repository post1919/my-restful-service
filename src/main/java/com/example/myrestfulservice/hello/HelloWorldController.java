package com.example.myrestfulservice.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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

    @GetMapping(path="/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale ){
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
