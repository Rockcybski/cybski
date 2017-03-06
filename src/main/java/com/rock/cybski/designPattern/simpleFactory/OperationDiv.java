package com.rock.cybski.designPattern.simpleFactory;

public class OperationDiv extends Operation {

	@Override
	public double getResult(){
		if (this._numberB == 0) {
			throw new RuntimeException("divisor can't be 0.");
		}
		return this._numberA / this._numberB;
	}
}
