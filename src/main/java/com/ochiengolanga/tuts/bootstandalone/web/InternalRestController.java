package com.ochiengolanga.tuts.bootstandalone.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unsecured")
public class InternalRestController {

    @GetMapping
    public String getUnsecuredMessage() {
        return "Hello, Am unsecured :-)";
    }
}
