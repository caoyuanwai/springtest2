package com.caoyuanwai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScopeController {
    @RequestMapping("/testModelAndView")
    public ModelAndView testModerAndView() {
        //处理模型数据，即向请求域request共享数据
        ModelAndView mav = new ModelAndView();
        mav.addObject("testRequestScope", "hello ModelAndView");
        mav.setViewName("success");
        return mav;
    }
}
