package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService bookService;
    @GetMapping //查询操作用Get
    //查询所有信息
    public List<Book> getAll(){
        return bookService.list();

    }

    @PostMapping //添加操作
    public boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping //update操作
    public boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }
    @DeleteMapping ("{id}")//update操作
    public boolean delete(@PathVariable Integer id){
        return bookService.removeById(id);
    }

    @GetMapping("{id}")//条件查询
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @GetMapping ("{currentPage}/{pageSize}")//分页
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return bookService.getPage(currentPage,pageSize);
    }
}
