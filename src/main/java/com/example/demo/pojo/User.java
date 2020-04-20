package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 项目名称：springboot_demo
 * 类 名 称：User
 * 类 描 述：TODO
 * 创建时间：2020/3/11 4:53 下午
 * 创 建 人：ZhuFangTao
 * @author fangtaozhu
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Integer status;
}
