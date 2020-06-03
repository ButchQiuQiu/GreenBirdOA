package com.butch.greenbirdoa.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

/**
 * ReflectUtil
 * 
 * 反射工具类,参与鉴权的分发
 */
@Component
public class ReflectUtil {

    /**
     * 通过方法名使用一个返回值是任一参数的方法 用于鉴权的分发
     * 
     * @param object     使用的对象
     * @param methodName 方法名
     * @param parms      参数
     * @return 方法返回值,没有找到方法会返回null(不添加健壮性代码那么程序就当无事发生)
     */
    public Object useMethodByMethodName(Object object, String methodName, Object... parms) {
        Method[] methods = object.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                try {
                    return method.invoke(object, parms);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}