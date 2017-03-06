package com.rock.cybski.designPattern.factoryMethod;

public class SubFactory implements OperationFactory{
	@Override
	public Operation createOperation() {
		return new OperationSub();
	}
}
