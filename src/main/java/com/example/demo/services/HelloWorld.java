package com.example.demo.services;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorld {
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String s1) {
        return "Hello World" + s1;
    }
}
