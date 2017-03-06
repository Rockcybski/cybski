package com.rock.cybski.designPattern.templateMethod;

public class Test {
	public static void main(String[] args) {
		AbstractClass c;
		c = new ConcreteClassA();
		c.templateMethod();
		
		c = new ConcreteClassB();
		c.templateMethod();
	}
}
