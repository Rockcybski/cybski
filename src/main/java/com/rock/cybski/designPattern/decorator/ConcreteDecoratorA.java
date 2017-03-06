package com.rock.cybski.designPattern.decorator;

public class ConcreteDecoratorA extends Decorator{
		private String aStatus;//本类独有
		
		@Override
		public void operation() {
			super.operation();
			aStatus = "ConcreteDecoratorA String";
			System.out.println("ConcreteDecoratorA的operation | " + aStatus);
		}

}
