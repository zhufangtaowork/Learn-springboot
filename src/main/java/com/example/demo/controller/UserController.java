package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.Constant;
import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.untils.JwtUtil;
import com.example.demo.untils.PasswordUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：springboot_demo
 * 类 名 称：DemoIndexController
 * 类 描 述：UserController
 * 创建时间：2020/3/11 4:16 下午
 * 创 建 人：ZhuFangTao
 *
 * @author fangtaozhu
 */
@Slf4j
@Api(value = "用户controller",tags = {"用户接口"})
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
        HashMap<String, Object> map = new HashMap<>(16);
        User user = userService.findUser(name, PasswordUtil.encrypt(password, Constant.ENCRYPTION_PASSWORD, PasswordUtil.getStaticSalt()));
        if (user == null) {
            return result.setMsgCode(ResultCode.REQUEST_ERROR);
        }
        String s = Constant.USER_MAP.get(user.getId());
        String token = new JwtUtil().createJWT(user.getId().toString(), JSON.toJSONString(user), Constant.EXP_TIME);
        map.put("token",token);
        map.put("userName",s);
        result.setData(map);
        result.setMsgCode(ResultCode.LOGIN_SUCCESS);
        return result;
    }

    @ApiOperation(value = "用户注册")
    @PutMapping(value = "userRegister")
    public Result userRegister(@RequestParam String name, String password) {
        Result result = new Result();
        String encryptPassword = PasswordUtil.encrypt(password, Constant.ENCRYPTION_PASSWORD, PasswordUtil.getStaticSalt());
        boolean blo = userService.addUser(name, encryptPassword);
        if (blo) {
            return result.setMsgCode(ResultCode.REQUEST_SUCCESS);
        }
        return result.setMsg("注册失败！");
    }

    @ApiOperation(value = "验证token接口")
    @PutMapping(value = "verifyToken")
    public String verifyInterface(HttpServletRequest request) {
        //验证token是否存在
        try {
            JwtUtil jwtUtil = new JwtUtil();
            Claims claims = jwtUtil.parseJWT(request.getHeader("Authorization"));
        } catch (Exception e) {
            return "未登陆或长时间无操作登陆已过期！";
        }
        return "您现在的位置是页面A";
    }

    @ApiOperation(value = "查询用户列表")
    @PostMapping(value = "users")
    public PageInfo<User> findAllUsers(
            @ApiParam(value = "pageNum",name = "页码",required = false) @RequestParam Integer pageNum,
            @ApiParam(value = "pageSize",name = "每页的条数",required = false) @RequestParam Integer pageSize
            ) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(userService::findAllUsers);
    }

    @ApiOperation(value = "添加用户")
    @PostMapping(value = "add/users")
    public Result addUsers(@ApiParam(value = "user",name = "用户",required = false) @RequestBody Map<String,Object> params) {
        Result result = new Result();
        boolean res = userService.addUsers(params);
        return result;
    }

}
