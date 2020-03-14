package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目名称：springboot_demo
 * 类 名 称：BaseController
 * 类 描 述：TODO
 * 创建时间：2020/3/14 2:37 下午
 * 创 建 人：ZhuFangTao
 * @author fangtaozhu
 */
@Controller
public class BaseController {
    @RequestMapping("/")
    public String jumpIndex(){
        return "index";
    }
}
