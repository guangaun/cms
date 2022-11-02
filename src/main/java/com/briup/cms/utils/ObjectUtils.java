package com.briup.cms.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

/**
 * @ClassName BeanUtils
 * @Description
 * @Author Gc
 * @Date 2022/11/2 14:47
 */
public class ObjectUtils {
    private ObjectUtils(){}

    public static <T>T vm2Bean(Object vm,Class<T> c){
        T target = null;
        try {
            target = c.newInstance();
            BeanUtils.copyProperties(vm,target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return target;
    }
}
