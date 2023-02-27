package com.example.controller;

import com.example.controller.utils.R;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping //查询操作用Get
    //查询所有信息
    public R getAll(){
        return new R(true,bookService.list());

    }

    @PostMapping //添加操作
    public R save(@RequestBody Book book){
//        R r = new R();
//        Boolean flag = bookService.save(book);
//        r.setFlag(flag);
        return new R(bookService.save(book));
    }

    @PutMapping //update操作
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }
    @DeleteMapping ("{id}")//update操作
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

    @GetMapping("{id}")//条件查询
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping ("{currentPage}/{pageSize}")//分页
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return new R(true,bookService.getPage(currentPage,pageSize));
    }
}
