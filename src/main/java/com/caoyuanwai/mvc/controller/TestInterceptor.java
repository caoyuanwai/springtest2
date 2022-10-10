package com.caoyuanwai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestInterceptor {
    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

    @RequestMapping("/testError")
    public String testError() {
        int i = 5/0;
        return "success";
    }
}
