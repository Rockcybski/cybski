package com.rock.cybski.designPattern.simpleFactory;

public class OperationMul extends Operation {

	@Override
	public double getResult() {
		return this._numberA * this._numberB;
	}

}
