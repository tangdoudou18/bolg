package com.tzk.boot.blog.blogtzk.controller;


import com.github.pagehelper.PageInfo;
import com.tzk.boot.blog.blogtzk.domain.User;
import com.tzk.boot.blog.blogtzk.service.UserService;
import com.tzk.boot.blog.blogtzk.util.ViolationExceptionHandler;
import com.tzk.boot.blog.blogtzk.vo.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.List;


/**
 * 用户控制器
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * list页面查询所有用户并且分页显示
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "5    ") int pageSize,
                             @RequestParam(required = false) boolean async,Model model) {

        PageInfo<User> userPageInfo = userService.listUserByNameLike(pageNum, pageSize);
        model.addAttribute("page", userPageInfo);
        model.addAttribute("userList", userPageInfo.getList());
        return new ModelAndView(async == true?"users/list :: #mainContainerRepleace":"users/list", "userModel",
                model);
    }

    /**
     * 获取创建表单页面
     *
     * @param model
     * @return
     */
    @GetMapping("/add")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("users/add", "userModel", model);
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @PostMapping
    public ResponseEntity<UserResponse> saveOrUpateUser(User user) {

        try {
            userService.saveUser(user);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.ok().body(new UserResponse(false, ViolationExceptionHandler.getMessage(e)));
        }

        return ResponseEntity.ok().body(new UserResponse(true, "处理成功", user));
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable("id") Long id) {
        try {
            userService.removeUser(id);
        } catch (Exception e) {
            return ResponseEntity.ok().body(new UserResponse(false, e.getMessage()));
        }

        return ResponseEntity.ok().body(new UserResponse(true, "处理成功"));
    }

    /**
     * 获取修改用户的界面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "edit/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User userById = userService.getUserById(id);
        model.addAttribute("user", userById);
        return new ModelAndView("users/edit", "userModel", model);
    }
}
