package com.tzk.boot.blog.blogtzk.dao;

import com.tzk.boot.blog.blogtzk.base.BaseDao;
import com.tzk.boot.blog.blogtzk.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDao extends BaseDao<User> {

    /**
     * 根据用户姓名分页查询用户列表
     * @param name
     * @param pageable
     * @return
     */
    @Select("select * from user")
    Page<User> findByNameLike(String name, Pageable pageable);
}
