package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;
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
        bookService.update(book);

    }

    @Test
    void testDelete(){
        bookService.delete(16);

    }

    @Test
    void testGetAll(){
        bookService.getAll();

    }

    @Test
    void testGetPage(){
        IPage page = bookService.getPage(1,5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());

    }



}
