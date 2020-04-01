package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;

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

    /**
     * @Author ZhuFangTao
     * @MethodName addUser
     * @Description 用户注册
     * @Date 2:28 下午 2020/3/13
     * @Param [name, encryptPassword]
     * @return boolean
     **/
    boolean addUser(String name, String encryptPassword);
    /**
     * @Author ZhuFangTao 
     * @MethodName findUsers
     * @Description 
     * @Date 2:25 上午 2020/3/22
     * @Param [threadId]
     * @return java.util.List<com.example.demo.pojo.User>
     *
     * @param threadId*/
    List<User> findUsers(int threadId);

    /**
     * @Author ZhuFangTao
     * @MethodName findAllUsers
     * @Description
     * @Date 11:06 上午 2020/4/1
     * @Param []
     * @return java.util.List<com.example.demo.pojo.User>
     **/
    List<User> findAllUsers();

}
