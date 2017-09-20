package cn.itcast.bos.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by 13718 on 2017/9/11.
 */
public class TUtils {
    public static Class getActualType(Class entity){
        ParameterizedType parameterizedType = (ParameterizedType) entity.getGenericSuperclass();
        Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
        return entityClass;
    }
}
