package com.ochiengolanga.tuts.bootstandalone.web;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloWorldController {

    @GetMapping
    public String greetings(@RequestParam(name = "name", required = false) String name) {
        if (StringUtils.isEmpty(name))
            return "Hello, Stranger";
        else
            return String.format("Hello, %s", name);
    }
}
