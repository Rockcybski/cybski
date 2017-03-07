package com.rock.cybski.baseJava.reflect;

public class ClassDemo3 {
	public static void main(String[] args) {
		String s = "hello";
		ClassUtil.printClassMessage(s);
		ClassUtil.printFieldMessage(s);
		ClassUtil.printConstructorMessage(s);
	}
}
