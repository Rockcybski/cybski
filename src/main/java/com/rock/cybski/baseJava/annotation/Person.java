package com.rock.cybski.baseJava.annotation;

@Description("I am Person")
public class Person {
	
	@Description("I am method name() of Person")
	public String name(){
		return null;};
	
	public int age(){
		return 0;};
	
	@Deprecated
	public void sing(){};
	
}
