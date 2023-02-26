package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;

import java.util.List;

public interface BookService {
    //保存
    boolean save(Book book);
    //修改
    boolean update(Book book);
    //删除
    boolean delete(Integer id);

    //查询
    Book getById(Integer id);

    //查全部
    List<Book> getAll();

    IPage<Book> getPage(int currentPage,int pageSize);
}
