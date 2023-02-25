package com.example.dao.impl;

import main.java.com.example.dao.BookDao;
import org.apache.catalina.startup.ClassLoaderFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaolmpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao is running");
    }
}
