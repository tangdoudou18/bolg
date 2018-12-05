package com.tzk.boot.blog.blogtzk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/u")
public class UserSpaceController {

    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username){
        System.out.println("username:"+username);
        return "/userspace/u";
    }

    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value = "order",required = false,defaultValue = "new") String order,
                                   @RequestParam(value = "category",required = false) Long category,
                                   @RequestParam(value = "keyword",required = false) String keyword){

        if(category != null){

            System.out.println("category:"+category);
            System.out.println("拼接链接:"+"redirect:/u/"+username+"/blogs?category="+category);
            return "/userspace/u";

        }else if (keyword != null && !keyword.isEmpty()){

            System.out.println("keyword:"+keyword);
            System.out.println("拼接链接:"+"redirect:/u/"+username+"/blogs?keyword="+keyword);
            return  "/userspace/u";
        }
        System.out.println("order:"+order);
        System.out.println("拼接链接:"+"redirect:/u/"+username+"/blogs?order="+order);
        return  "/userspace/u";
    }

    @GetMapping("/{username}/blog/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id){

        System.out.println("blogID:"+id);
        return "/userspace/blog";
    }

    @GetMapping("/{username}/blogs/edit")
    public String editBlog(){

        return "/userspace/blogedit";
    }

}
