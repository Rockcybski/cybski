package com.rock.cybski.designPattern.simpleFactory;

public class OperationSub extends Operation{

	@Override
	public double getResult() {
		return this._numberA - this._numberB;
	}

}
