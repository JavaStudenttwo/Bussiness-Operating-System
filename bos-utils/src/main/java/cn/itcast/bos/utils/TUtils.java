package cn.itcast.bos.utils;

import java.lang.reflect.ParameterizedType;

/**
 * @Date 2017/10/10 14:45
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.utils
 * @ClassName: TUtils
 * @Description: 泛型转换
 *
 */
public class TUtils {
    public static Class getActualType(Class entity){
        ParameterizedType parameterizedType = (ParameterizedType) entity.getGenericSuperclass();
        Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
        return entityClass;
    }
}
