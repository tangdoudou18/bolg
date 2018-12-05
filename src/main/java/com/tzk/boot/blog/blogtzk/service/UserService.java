package com.tzk.boot.blog.blogtzk.service;

import com.github.pagehelper.PageInfo;
import com.tzk.boot.blog.blogtzk.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 保存用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 注册用户
     */
    int registerUser(User user);

    /**
     * 删除用户
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     */
    User getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     */

    PageInfo<User> listUserByNameLike(int pageNum, int pageSize);


    List<User> getUsersAll();

}
