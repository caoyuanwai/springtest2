package com.caoyuanwai.spring.service;

import com.caoyuanwai.spring.dao.BookDao;
import com.caoyuanwai.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    //增加的方法
    public void addBook(Book book) {
        bookDao.add(book);
    }

    //修改的方法
    public void update(Book book) {
        bookDao.update(book);
    }

    //删除的方法
    public void delete(int id) {
        bookDao.delete(id);
    }

    //查询总数
    public int findCount() {
        return bookDao.findCount();
    }

    //查询对象
    public Book findOne(int id) {
        return bookDao.findOne(id);
    }
    //查询所有
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    //批量添加
    public void batchAdd(List<Object[]> args) {
        bookDao.batchAdd(args);
    }

    //批量更改
    public void batchUpdate(List<Object[]> args) {
        bookDao.batchUpdate(args);
    }
    //批量删除
    public void batchDelete(List<Object[]> args) {
        bookDao.batchDelete(args);
    }
}
