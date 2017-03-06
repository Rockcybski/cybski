package com.rock.cybski.designPattern.simpleFactory;

/*
 * 简单工厂模式实现
 */
public class OperationFactory {
	public static Operation createOperation(String operation){
		//can change to use switch if using jdk1.7+ ???
		if(Operation.OPERATION_ADD.equals(operation))
			return new OperationAdd();
		if(Operation.OPERATION_SUB.equals(operation))
			return new OperationSub();
		if(Operation.OPERATION_MUL.equals(operation))
			return new OperationMul();
		if(Operation.OPERATION_DIV.equals(operation))
			return new OperationDiv();
		return null;
	}
}
