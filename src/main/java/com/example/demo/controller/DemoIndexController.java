package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：springboot_demo
 * 类 名 称：DemoIndexController
 * 类 描 述：TODO
 * 创建时间：2020/3/11 4:16 下午
 * 创 建 人：ZhuFangTao
 * @author fangtaozhu
 */
@RestController
@RequestMapping("spring/v1")
public class DemoIndexController {

    private final UserService userService;

    public DemoIndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login")
    public Map<String,Object> login(@RequestParam String name,String password){
        User user = userService.findUser(name,password);
        HashMap<String, Object> paramsMap = new HashMap<>(16);
        if (user == null){
            paramsMap.put("msg","登陆失败!");
        }
        paramsMap.put("msg","登陆成功!");
        return paramsMap;
    }
}
