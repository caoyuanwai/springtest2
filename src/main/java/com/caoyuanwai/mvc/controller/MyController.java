package com.caoyuanwai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/testRequestBody")
    public String testRequestBody() {
        return "testRequestBody";
    }
}
