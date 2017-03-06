package com.rock.cybski.designPattern.factoryMethod;

/*
 * 工厂方法模式 （Factory　Method），　定义一个用于创建对象的接口，让其子类决定实例化哪一个类。使一个类的实例化延迟到其子类
 */
public class OperationTest {
	public static void main(String[] args) {
		OperationFactory factory = new DivFactory();
		Operation oper = factory.createOperation();
		oper.set_numberA(10);
		oper.set_numberB(2);
		System.out.println(oper.getResult());
	}
}	
