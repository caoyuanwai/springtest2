package com.caoyuanwai.mvc.controller;

import com.caoyuanwai.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name", required = false, defaultValue = "hehe") String username,
            String password,
            String[] hobby,
            @RequestHeader("Host") String Host,
            @CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println("username:" + username + "，password:" + password + ",hobby:" + Arrays.toString(hobby));
        System.out.println("JSESSIONID:" + JSESSIONID);
        System.out.println("Host:" + Host);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/param")
    public String param() {
        return "test_param";
    }
}
