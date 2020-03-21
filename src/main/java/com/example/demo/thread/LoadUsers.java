package com.example.demo.thread;

import com.example.demo.common.Constant;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.untils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 项目名称：springboot_demo
 * 类 名 称：LoadUsers
 * 类 描 述：TODO
 * 创建时间：2020/3/22 1:17 上午
 *
 * @author：ZhuFangTao
 */
public class LoadUsers implements Runnable{
    private int threadId;
    private CountDownLatch latch;

    public LoadUsers(int threadId, CountDownLatch latch) {
        this.threadId = threadId;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            UserService userService = (UserService)SpringUtils.getBean("UserServiceImpl");
            List<User> userList = userService.findUsers(threadId);
            for (User u :
                    userList) {
                Constant.USER_MAP.put(u.getId(), u.getName());
            }
            System.out.println("这是线程："+threadId+"查出来的"+"userList = " + userList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            latch.countDown();
        }



    }
}
