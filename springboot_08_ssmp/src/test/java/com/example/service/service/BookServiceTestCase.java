package com.example.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private IBookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("test123");
        book.setName("test123");
        book.setDescription("test123");
        bookService.save(book);

    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("test123");
        book.setName("test123");
        book.setDescription("test123");
        bookService.updateById(book);

    }

    @Test
    void testDelete(){
        bookService.removeById(16);

    }

    @Test
    void testGetAll(){
        bookService.list();

    }

    @Test
    void testGetPage(){
        IPage<Book> page = new Page<Book>(2,5);
        bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());

    }



}
