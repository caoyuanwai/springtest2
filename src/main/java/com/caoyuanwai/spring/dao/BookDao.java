package com.caoyuanwai.spring.dao;

import com.caoyuanwai.spring.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    void update(Book book);

    void delete(int id);

    int findCount();

    Book findOne(int id);

    List<Book> findAll();

    void batchAdd(List<Object[]> args);

    void batchUpdate(List<Object[]> args);

    void batchDelete(List<Object[]> args);
}
