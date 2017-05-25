package com.rock.cybski.baseJava.jdk8;

public interface JDK8Interface {
	void print();
	public default void defaultPrint(){
		System.out.println("default method");
	}
	public static void staticPrint(){
		System.out.println("static method");
	}
}
