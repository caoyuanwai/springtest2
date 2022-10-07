package com.caoyuanwai.mvc.controller;

import com.caoyuanwai.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
}
