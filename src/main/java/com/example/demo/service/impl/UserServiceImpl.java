package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 项目名称：springboot_demo
 * 类 名 称：UserServiceImpl
 * 类 描 述：TODO
 * 创建时间：2020/3/11 4:59 下午
 * 创 建 人：ZhuFangTao
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUser(String name, String password) {
        User user = userMapper.findUser(name,password);
        if (user == null){
            return null;
        }
        return user;
    }

    @Override
    public boolean addUser(String name, String encryptPassword) {
        int i = userMapper.addUser(name,encryptPassword);
        return i>0;
    }
}
