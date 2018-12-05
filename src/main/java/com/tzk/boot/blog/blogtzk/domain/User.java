package com.tzk.boot.blog.blogtzk.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.List;

@Data//lombok自动生成各种方法
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    @Id     //标识一个主键
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    private Long id;
    @Column
    private String name;
    @Email(message = "邮箱格式不正确")
    private String email;
    private String username;
    private String password;
    private String avatar;



}
