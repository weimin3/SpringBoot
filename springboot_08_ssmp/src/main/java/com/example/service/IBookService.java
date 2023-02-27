package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;
//业务层接口，功能如 BookService
public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int currentPage,int pageSize);

}
