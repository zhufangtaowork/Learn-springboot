package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.Constant;
import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.untils.JwtUtil;
import com.example.demo.untils.PasswordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 项目名称：springboot_demo
 * 类 名 称：DemoIndexController
 * 类 描 述：UserController
 * 创建时间：2020/3/11 4:16 下午
 * 创 建 人：ZhuFangTao
 * @author fangtaozhu
 */
@Slf4j
@Api(tags = {"用户接口"})
@RestController
@RequestMapping("spring/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "用户登录")
    @GetMapping(value = "login")
    public Result login(@RequestParam String name, String password) throws Exception {
        Result result = new Result();
        User user = userService.findUser(name,PasswordUtil.encrypt(password, Constant.ENCRYPTION_PASSWORD, PasswordUtil.getStaticSalt()));
        if (user == null){
            return result.setMsgCode(ResultCode.REQUEST_ERROR);
        }
        String token = new JwtUtil().createJWT(user.getId().toString(), JSON.toJSONString(user), Constant.EXP_TIME);
        result.setData(token);
        result.setCode(ResultCode.LOGIN_SUCCESS);
        return result;
    }

    @ApiOperation(value = "用户注册")
    @PutMapping(value = "userRegister")
    public Result userRegister(@RequestParam String name, String password){
        Result result = new Result();
        String encryptPassword = PasswordUtil.encrypt(password, Constant.ENCRYPTION_PASSWORD, PasswordUtil.getStaticSalt());
        boolean blo = userService.addUser(name,encryptPassword);
        if (blo){
            return result.setMsgCode(ResultCode.REQUEST_SUCCESS);
        }
        return result.setMsg("注册失败！");
    }

}
