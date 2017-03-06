package com.rock.cybski.baseJava.reflect;

import java.lang.reflect.Method;

public class Method1 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		//获取print(int,int)方法
		//1. 要获取一个方法，首先获取类的class type
		A a1 = new A();
		Class c = a1.getClass();
		/*2. 获取方法 名称和参数表来觉得
		 * getMethods方法获取的是所有的public函数，包括父类继承而来的
		 * getDeclaredMethods获取的是所有该类自己声明的方法，不论访问权限
		 */
		try {
			//Method m = c.getMethod("print", new Class[]{int.class, int.class});
			Method m = c.getMethod("print", int.class, int.class);
			
			//方法的反射操作
			//a1.print(10,20);方法的反射操作是用m对象来进行调用，和a1.print调用效果一样
			//m.invoke, 方法如果没有返回值返回null，有返回值返回具体的返回值
			m.invoke(a1, new Object[]{10,20});
			System.out.println("====================================");
			
			Method m1 = c.getMethod("print", String.class, String.class);
			m1.invoke(a1, "aaa", "BBB");
			System.out.println("====================================");
			
			Method m2 = c.getMethod("print");//c.getMethod("print", new Class[]{});
			m2.invoke(a1);//m2.invoke(a1, new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
class A{
	public void print(){
		System.out.println("Hello");
	}
	public void print(int a, int b){
		System.out.println(a+b);
	}
	public void print(String a, String b){
		System.out.println(a.toUpperCase()+","+b.toLowerCase());
	}
}
