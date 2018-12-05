package com.tzk.boot.blog.blogtzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.tzk.boot.blog.blogtzk.dao")
public class BlogTzkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogTzkApplication.class, args);
    }
}
