package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 项目名称：springboot_demo
 * 类 名 称：UserMapper
 * 类 描 述：TODO
 * 创建时间：2020/3/11 5:02 下午
 * 创 建 人：ZhuFangTao
 * @author fangtaozhu
 */
@Mapper
public interface UserMapper {
    /**
     * @Author ZhuFangTao
     * @MethodName findUser
     * @Description 查询用户是否存在
     **/
    User findUser(@Param("name") String name, @Param("password") String password);

    /**
     * @Author ZhuFangTao
     * @MethodName addUser
     * @Description 添加用户
     * @Date 2:29 下午 2020/3/13
     * @Param [name, encryptPassword]
     * @return int
     **/
    int addUser(String name, String encryptPassword);

    /**
     * @Author ZhuFangTao
     * @MethodName findUsers
     * @Description
     * @Date 1:44 上午 2020/3/22
     * @Param []
     * @return java.util.List<com.example.demo.pojo.User>
     *
     * @param threadId
     **/
    List<User> findUsers(@Param("threadId") int threadId);

    List<User> findAllUsers();

    Integer addUsers(Map<String, Object> params);
}
