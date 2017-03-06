package com.rock.cybski.designPattern.decorator;

/*
 * 装饰模式（Decorator），动态的给一个对象添加一些额外的职责，就增加功能来说
 * 装饰模式比生成子类更为灵活
 * 
 * Component 定义一个对象接口，可以给这些对象动态地添加职责
 * ComcreteComponent 定义了一个具体的对象，也可以给对象添加一些职责
 * Decorator 装饰抽象类，继承了Component， 从外类来扩展Component类的功能，但对于Component，无需知道Decorator
 * ConcreteDecorator是 具体的装饰对象，起到给Component添加职责的功能
 * 
 * 利用SetComponent()来对对象进行包装，每个装饰对象的实现就和如何使用这个对象分离开了，
 * 每个装饰对象只关心自己的功能，不需要关心如何被添加到对象链当中
 */

public class DecoratorTest {
	public static void main(String[] args) {
		ConcreteComponent c = new ConcreteComponent();
		ConcreteDecoratorA da = new ConcreteDecoratorA();
		ConcreteDecoratorB db = new ConcreteDecoratorB();
		da.setComponent(c);
		db.setComponent(da);
		db.operation();
	}
}
