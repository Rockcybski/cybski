package com.rock.cybski.designPattern.factoryMethod;

public class OperationSub extends Operation{

	@Override
	public double getResult() {
		return this._numberA - this._numberB;
	}

}
