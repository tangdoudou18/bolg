package com.tzk.boot.blog.blogtzk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tzk.boot.blog.blogtzk.dao.UserDao;
import com.tzk.boot.blog.blogtzk.domain.User;
import com.tzk.boot.blog.blogtzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 用户服务接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public int saveUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public int registerUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public void removeUser(Long id) {
        userDao.deleteByPrimaryKey(id);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.selectByPrimaryKey(id);
    }



    /**
     * 暂时定为分页查询
     * @param pageNum
     * @param pageSize
     * @return：
     */
    @Override
    public PageInfo<User> listUserByNameLike(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userDao.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    @Override
    public List<User> getUsersAll() {
        List<User> users = userDao.selectAll();
        return users;
    }
}
