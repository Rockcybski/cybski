package com.rock.cybski.designPattern.factoryMethod;

public abstract class Operation {
	public static String OPERATION_ADD = "+";
	public static String OPERATION_SUB = "-";
	public static String OPERATION_MUL = "*";
	public static String OPERATION_DIV = "/";
	
	protected double _numberA;
	protected double _numberB;
	public double get_numberA() {
		return _numberA;
	}
	public void set_numberA(double _numberA) {
		this._numberA = _numberA;
	}
	public double get_numberB() {
		return _numberB;
	}
	public void set_numberB(double _numberB) {
		this._numberB = _numberB;
	}
	public abstract double getResult();
}
