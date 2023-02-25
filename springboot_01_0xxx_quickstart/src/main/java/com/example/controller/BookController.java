package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {
    //开发查询
    @GetMapping
    public String getById(){
        System.out.println("Springboot is running...");
        return "Springboot is running...";
    }
}
