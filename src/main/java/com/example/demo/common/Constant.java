package com.example.demo.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：springboot_demo
 * 类 名 称：Constant
 * 类 描 述：TODO
 * 创建时间：2020/3/13 12:18 下午
 * 创 建 人：ZhuFangTao
 * @author fangtaozhu
 */
public class Constant {
    public static final int THREAD_NUM = 2;
    /**
     * token过期时间 一分钟
     */
    public static final long EXP_TIME = 60*1000;
    /**
     * 加密密码
     */
    public static final String ENCRYPTION_PASSWORD = "root_password_123456";

    public static final Map<Integer,String> USER_MAP = new HashMap<>();
}
