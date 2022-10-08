package com.caoyuanwai.mvc.controller;

import com.caoyuanwai.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpController {
    @RequestMapping("/testHttpMessageConverter")
    public String testRequestBody() {
        return "testHttpMessageConverter";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> entity) {
        System.out.println("请求头：" + entity.getHeaders() + "\n" + "请求体：" + entity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }


    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        return new User(1001, "admin", "123", 25, "男", "123@qq.com");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println(username + "," + password);
        return "hello testAxios";
    }
}
