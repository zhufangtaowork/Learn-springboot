package com.example.demo.common;

import java.util.HashMap;

/**
 * 项目名称：springboot_demo
 * 类 名 称：ResultCode
 * 类 描 述：状态码
 * 创建时间：2020/3/12 4:44 下午
 * 创 建 人：ZhuFangTao
 *
 * @author fangtaozhu
 */
public class ResultCode {
    public static final HashMap<String, String> msg = new HashMap();
    /**
     * 登陆
     **/
    public static final String LOGIN_SUCCESS = "0000";

    /**
     * 请求
     **/
    public static final String REQUEST_SUCCESS = "2000";
    public static final String REQUEST_ERROR = "1000";

    /**
     * 参数
     **/
    public static final String PARAM_IS_INVALID = "1001";
    public static final String PARAM_IS_EMPTY = "2001";
    public static final String PARAM_NOT_COMPLETE = "2002";

    static {
        msg.put(LOGIN_SUCCESS,"登陆成功!");
        msg.put(REQUEST_SUCCESS,"请求成功!");
        msg.put(REQUEST_ERROR,"请求失败!");
        msg.put(PARAM_IS_INVALID,"参数无效!");
        msg.put(PARAM_IS_EMPTY,"参数为空!");
        msg.put(PARAM_NOT_COMPLETE,"缺少必要参数!");
    }
}
