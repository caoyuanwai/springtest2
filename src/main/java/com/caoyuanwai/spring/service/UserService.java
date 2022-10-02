package com.caoyuanwai.spring.service;

import com.caoyuanwai.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void accountMoney() {
        userDao.reduceMoney();
        userDao.addMoney();
    }
}
