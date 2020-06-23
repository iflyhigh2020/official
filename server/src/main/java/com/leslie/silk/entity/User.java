package com.leslie.silk.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:55:39
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 467102619592503852L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private Date createTime;
    
    private Date updateTime;

    /**
     *新密码（修改密码时使用）
     */
    private String newPwd;
}