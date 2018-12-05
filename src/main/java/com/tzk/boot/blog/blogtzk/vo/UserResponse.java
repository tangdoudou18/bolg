package com.tzk.boot.blog.blogtzk.vo;


import lombok.Data;

@Data
public class UserResponse {
    private boolean success;  //处理是否成功
    private String message;  //处理后的消息提示
    private Object data;  //返回的数据

    public UserResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public UserResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public UserResponse() {
    }
}
