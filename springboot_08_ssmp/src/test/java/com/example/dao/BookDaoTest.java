package com.example.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;
    @Test
    void testGetById(){
//        System.out.println(bookDao.getById(1));
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("test123");
        book.setName("test123");
        book.setDescription("test123");
        bookDao.insert(book);

    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("test123");
        book.setName("test123");
        book.setDescription("test123");
        bookDao.updateById(book);

    }

    @Test
    void testDelete(){
        bookDao.deleteById(16);

    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);

    }

    @Test
    void testGetPage(){
        IPage page = new Page(1,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());

    }

//    @Test
//    void testGetBy(){
//        QueryWrapper<Book> qw = new QueryWrapper<>();
//        qw.like("name","spring"); //名字中包含spring的书
//        bookDao.selectList(qw);
//
//    }

    @Test
    void testGetBy(){
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null,Book::getName,name); //名字中包含spring的书
        bookDao.selectList(lqw);

    }

}
