package com.rock.cybski.designPattern.simpleFactory;

public class OperationTest {
	public static void main(String[] args) {
		Operation oper = OperationFactory.createOperation(Operation.OPERATION_DIV);
		oper.set_numberA(10);
		oper.set_numberB(2);
		System.out.println(oper.getResult());
	}
}	
