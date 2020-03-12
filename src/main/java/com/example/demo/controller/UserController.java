package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：springboot_demo
 * 类 名 称：DemoIndexController
 * 类 描 述：UserController
 * 创建时间：2020/3/11 4:16 下午
 * 创 建 人：ZhuFangTao
 * @author fangtaozhu
 */
@Slf4j
@RestController
@RequestMapping("spring/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login")
    public Result login(@RequestParam String name, String password){
        Result result = new Result();
        User user = userService.findUser(name,password);
        if (user == null){
           return result.setMsgCode(ResultCode.REQUEST_ERROR);
        }
        return result.setMsgCode(ResultCode.LOGIN_SUCCESS);
    }
}
