package com.caoyuanwai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String hello() {
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return "target";
    }
}
