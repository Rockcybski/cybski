package com.rock.cybski.designPattern.factoryMethod;

public class MulFactory implements OperationFactory{
	@Override
	public Operation createOperation() {
		return new OperationMul();
	}
}
