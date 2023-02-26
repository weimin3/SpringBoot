package com.example.domain;

import lombok.Data;

//lombok:一个java类库，提供一组注解，简化POJO实体类开发
@Data //简化get/set 也可用@AllArgsConstructor 和 @NoArgsConstructor 进行无参和全参构造方法

public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
