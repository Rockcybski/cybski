package com.rock.cybski.baseJava.annotation;

@Description("I am class Child")
public class Child extends Person{

	@Override
	@Description("I am method name() of Child")
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int age() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		
	}

}
