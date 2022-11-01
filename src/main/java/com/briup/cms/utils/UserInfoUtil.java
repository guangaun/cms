package com.briup.cms.utils;

import java.util.Map;

/**
 * @ClassName UserInfoUtil
 * @Description
 * @Author Gc
 * @Date 2022/11/1 9:39
 */
public class UserInfoUtil {

    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();
    public static void setUserInfo(Map<String,Object> map){
        threadLocal.set(map);
    }
    public static Integer getUserId(){
        return (Integer) threadLocal.get().get("userId");
    }

}
