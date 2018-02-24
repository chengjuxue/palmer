package com.palmer.demo.annotation;

import java.lang.annotation.*;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/12, at 下午5:34
 * @Modified by:
 * @Description:
 */
@Documented//这个Annotation可以被写入javadoc
@Inherited//这个Annotation 可以被继承
@Retention(RetentionPolicy.RUNTIME)//表示这个Annotation存入jvm,运行时读取
@Target(ElementType.TYPE) //表示这个Annotation只能用于类
public @interface MybatisMapper {
    String name() default "";
}
