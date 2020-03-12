package com.example.demo.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 项目名称：springboot_demo
 * 类 名 称：User
 * 类 描 述：TODO
 * 创建时间：2020/3/11 4:53 下午
 * 创 建 人：ZhuFangTao
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
