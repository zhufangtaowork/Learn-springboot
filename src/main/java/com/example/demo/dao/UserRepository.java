package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * 项目名称：springboot_demo
 * 类 名 称：UserRepository
 * 类 描 述：TODO
 * 创建时间：2020/4/16 4:50 下午
 *
 * @author：ZhuFangTao
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    /**
     * fetch data by rule id
     *
     * @param name rule id
     * @param password page number
     * @return Result<User>
     */
    User findByNameAndPassword(String name,String password);

}
