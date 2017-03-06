package com.rock.cybski.designPattern.factoryMethod;

public class DivFactory implements OperationFactory{
	@Override
	public Operation createOperation() {
		return new OperationDiv();
	}
}