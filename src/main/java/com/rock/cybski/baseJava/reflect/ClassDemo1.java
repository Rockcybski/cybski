package com.rock.cybski.baseJava.reflect;

public class ClassDemo1 {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//任何一个类都是Class的实例对象，这个实例对象有三种表示方式
		//第一种表达方式，任何一个类都有一个隐含的静态成员变量class
		Class c1 = Foo.class;
		
		//第二种表达方式, 已知该类的对象通过getClass方法
		Foo f1 = new Foo();
		Class c2 = f1.getClass();
		
		/*c1, c2 表示了Foo类的类类型 -- class type
		 * 万事万物皆对象
		 * 类也是对象，是Class类的实例对象
		 * 这个对象我们成为该类的类类型
		 */
		
		//c1 or c2 都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
		System.out.println(c1 == c2); //true
		
		//第三种表达方式
		Class c3 = null;
		try {
			c3=Class.forName("reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2 == c3); //true
		
		//我们可以通过类的类类型来创建该对类的对象实例
		try {
			Foo foo = (Foo) c1.newInstance(); //需要无参数的构造方法
			foo.print();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

class Foo{
	public void print(){
		System.out.println("Foo");
	}
}
