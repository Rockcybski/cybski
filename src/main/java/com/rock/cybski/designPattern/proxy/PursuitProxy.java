package com.rock.cybski.designPattern.proxy;

public class PursuitProxy implements GiveGift{
	
	private Pursuit pursuit;
	
	public PursuitProxy(SchoolGirl mm){
		pursuit = new Pursuit(mm);
	}

	@Override
	public void giveMoney() {
		pursuit.giveMoney();
	}

	@Override
	public void giveFlower() {
		pursuit.giveFlower();
	}

	@Override
	public void giveChocolate() {
		pursuit.giveChocolate();
	}
	
}
