package com.rock.cybski.designPattern.simpleFactory;

public class OperationAdd extends Operation {

	@Override
	public double getResult() {
		return this._numberA + this._numberB;
	}
	
}
