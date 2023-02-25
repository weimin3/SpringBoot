package com.example;

import main.java.com.example.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02JunitApplicationTests {
    //1.注入要测试的对象
    @Autowired
    private BookDao bookDao;


    @Test
    void contextLoads() {
        //2.执行要测试的对象对应的方法
        bookDao.save();
    }

}
