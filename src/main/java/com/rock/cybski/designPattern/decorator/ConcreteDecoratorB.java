package com.rock.cybski.designPattern.decorator;

public class ConcreteDecoratorB extends Decorator{
	@Override
	public void operation() {
		super.operation();
		bOnly();
		System.out.println("ConcreteDecoratorB的operation()");
	}
	
	private void bOnly(){
		System.out.println("ConcreteDecoratorB Only");
	}

}
