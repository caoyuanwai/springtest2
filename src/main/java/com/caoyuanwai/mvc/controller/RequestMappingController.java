package com.caoyuanwai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class RequestMappingController {
    @RequestMapping(
            value = {"/testRequestMapping","/test"},
            method = {RequestMethod.GET,RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

//    @GetMapping("/testGetMapping")
    @PostMapping("/testPostMapping")
    public String test() {
        return "success";
    }

    @RequestMapping(value = "/testParams", params = {"username", "password=123"})
    public String testParams() {
        return "success";
    }
}
