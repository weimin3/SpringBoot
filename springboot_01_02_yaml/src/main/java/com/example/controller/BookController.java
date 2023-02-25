package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById(){
        System.out.println("sp is running....");
        return "sp is running..";
        System.out.println(myDataSource);
    }
}
