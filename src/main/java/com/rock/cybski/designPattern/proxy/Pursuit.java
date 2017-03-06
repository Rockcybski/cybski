package com.rock.cybski.designPattern.proxy;

public class Pursuit implements GiveGift{
	
	private SchoolGirl mm;
	
	public Pursuit(SchoolGirl mm){
		this.mm = mm;
	}
	
	@Override
	public void giveMoney() {
		System.out.println(mm.getName() + "，Pursuit送你钱");
	}

	@Override
	public void giveFlower() {
		System.out.println(mm.getName() + "，Pursuit送你花");
	}

	@Override
	public void giveChocolate() {
		System.out.println(mm.getName() + "，Pursuit送你巧克力");
	}

}
