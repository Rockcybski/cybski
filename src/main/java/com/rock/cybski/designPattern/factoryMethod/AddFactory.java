package com.rock.cybski.designPattern.factoryMethod;

public class AddFactory implements OperationFactory {

	@Override
	public Operation createOperation() {
		return new OperationAdd();
	}

}
