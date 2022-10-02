package com.caoyuanwai.spring.dao;

import com.caoyuanwai.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.List;

@Repository
public class BoolDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql = "insert into book values(null,?,?)";
        int update = jdbcTemplate.update(sql, book.getName(), book.getStatus());
        System.out.println(update);
    }

    @Override
    public void update(Book book) {
        String sql = "update book set name = ?,status = ? where id = ?";
        int update = jdbcTemplate.update(sql, book.getName(), book.getStatus(), book.getId());
        System.out.println(update);

    }

    @Override
    public void delete(int id) {
        String sql = "delete from book where id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public int findCount() {
        String sql = "select count(*) from book";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book findOne(int id) {
        String sql = "select * from book where id = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        String sql = "select * from book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void batchAdd(List<Object[]> args) {
        String sql = "insert into book values(null,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdate(List<Object[]> args) {
        String sql = "update book set name = ?,status = ? where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> args) {
        String sql = "delete from book where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }
}
