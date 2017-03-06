package com.rock.cybski.designPattern.factoryMethod;

public class OperationMul extends Operation {

	@Override
	public double getResult() {
		return this._numberA * this._numberB;
	}

}
