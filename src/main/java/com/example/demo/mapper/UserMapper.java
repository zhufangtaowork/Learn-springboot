package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
