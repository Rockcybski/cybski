package com.rock.cybski.baseJava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取类的信息
 * @author Rock Zhang
 *
 */
public class ClassUtil {
	/**
	 * 打印类的信息，包括类的成员函数
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	public static void printClassMessage(Object obj){
		//获取类的信息， 首先获取类的类类型
		Class c = obj.getClass();//传递的是哪个子类的对象， c就是该子类的类类型
		
		//获取类的名称
		System.out.println("类的名称是： " + c.getName());
		
		//获取方法
		/*
		 * Method类，方法对象
		 * 一个成员方法就是一个Method对象
		 * getMethods()方法获取的是所有的public函数，包括父类继承而来的
		 * getDeclaredMethods()获取的是所有该类自己声明的方法，不论访问权限
		 */
		System.out.println("类方法");
		Method[] methods = c.getMethods();//c.getDeclareMethods()
		for(int i=0;i<methods.length;i++){
			//得到方法的返回值类型的类类型
			Class returnType = methods[i].getReturnType();
			System.out.print(returnType.getName()+" ");
			//得到方法的名称
			System.out.print(methods[i].getName()+"(");
			//获取参数类型-->得到的是参数列表的类型的类类型
			Class[] paramTypes = methods[i].getParameterTypes();
			StringBuffer temp = new StringBuffer();
			for(Class class1:paramTypes){
				temp.append(class1.getName()+" ,");
			}
			if(temp.length()>0) temp.deleteCharAt(temp.lastIndexOf(","));
			System.out.println(temp.toString()+")");
		}
	}
	
	/**
	 * 打印类的成员变量信息
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	public static void printFieldMessage(Object obj) {
		//获取成员变量
		/*
		 * 成员变量也是对象
		 * java.lang.reflect.Field
		 * Field类封装了关于成员变量的操作
		 * getFields()获取所有public成员变量的信息
		 * getDeclaredFields()获取该类自己声明的成员变量信息
		 */
		Class c = obj.getClass();
		//Field[] fs = c.getFields();
		Field[] fs = c.getDeclaredFields();
		System.out.println("成员变量");
		for(Field field:fs){
			//得到成员变量的类型的类类型
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			String fieldName = field.getName();
			System.out.println(typeName+" "+fieldName);
		}
	}
	
	/**
	 * 打印对象的构造函数的信息
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	public static void printConstructorMessage(Object obj){
		Class c = obj.getClass();
		/*
		 * 构造函数也是对象
		 * java.lang.Constructor中封装了构造函数的信息
		 * getConstructors()获取所有的public的构造函数
		 * getDeclaredConstructors()得到所有的构造函数
		 */
		Constructor[] cs = c.getDeclaredConstructors();
		System.out.println("类的构造方法:");
		for(Constructor constructor:cs){
			System.out.print(constructor.getName()+"(");
			//获取构造函数的参数列表-->得到的是参数列的类类型
			Class[] paramTypes = constructor.getParameterTypes();
			StringBuffer temp = new StringBuffer();
			for(Class class1:paramTypes){
				temp.append(class1.getName()+" ,");
			}
			if(temp.length()>0) temp.deleteCharAt(temp.lastIndexOf(","));
			System.out.println(temp.toString()+")");
		}
	}
}
