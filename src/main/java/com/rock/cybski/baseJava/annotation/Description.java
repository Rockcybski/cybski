package com.rock.cybski.baseJava.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *自定义注解
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})//作用域
@Retention(RetentionPolicy.RUNTIME)//生命周期
@Inherited //可被子类继承
@Documented //生成javadoc时包含此注解
public @interface Description {
	String value();//成员变量，类型受限，只允许原始类型, 如果只有一个成员变量，必须使用名为value
					//注解可以没有成员，没有成员的注解成为标识注解
}
