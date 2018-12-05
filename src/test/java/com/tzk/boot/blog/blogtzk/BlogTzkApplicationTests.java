package com.tzk.boot.blog.blogtzk;

import com.tzk.boot.blog.blogtzk.dao.UserDao;
import com.tzk.boot.blog.blogtzk.domain.User;
import com.tzk.boot.blog.blogtzk.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogTzkApplicationTests {

    @Autowired
    private UserService service;
    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        User user = new User(null,"测试","1155888@qq.com","测试姓名","test",null);
        for (int i = 0 ; i < 102; i++){
            service.saveUser(user);

        }
    }

}
