package com.rock.cybski.designPattern.strategy;

/*
 * 策略模式是一种定义了一系列算法的的方法，从概念上来看，所有这些方法都完成了相同的工作，只是实现不同
 * 以相同的方式调用所有的算法，减少了使用算法类之间的耦合
 */
public class Context {
	private Strategy strategy;
	
	//将Strategy实例化的过程（简单工厂模式应用）
	public Context(int type){
		switch (type) {
		case 1:
			strategy = new StrategyA();
			break;
		case 2:
			strategy = new StrategyB();
			break;
		case 3:
			strategy = new StrategyC();
			break;
		default:
			break;
		}
	}
	
	public void doAction(){
		strategy.action();
	}
	
	public static void main(String[] args) {
		//使用不同的算法只需要在构造Context时传入不同的type
		Context c = new Context(1);
		c.doAction();
	}
}
