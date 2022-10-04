package com.caoyuanwai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String hello() {
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }
}
