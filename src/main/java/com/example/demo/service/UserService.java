package com.example.demo.service;

import com.example.demo.pojo.User;

/**
 * 项目名称：springboot_demo
 * 类 名 称：UserService
 * 类 描 述：TODO
 * 创建时间：2020/3/11 4:57 下午
 * 创 建 人：ZhuFangTao
 * @author fangtaozhu
 */
public interface UserService {
    /**
     * @Author ZhuFangTao
     * @MethodName findUser
     * @Description
     * @Date 4:58 下午 2020/3/11
     * @Param [name, password]
     * @return com.example.demo.pojo.User
     **/
    User findUser(String name, String password);
}
