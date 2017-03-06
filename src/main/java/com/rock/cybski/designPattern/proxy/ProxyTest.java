package com.rock.cybski.designPattern.proxy;

/*
 * 代理模式（Proxy)，为其他对象提供一种代理以控制对此对象的方位
 * 
 * 如下例，PursuitProxy是Pursuit的代理
 */
public class ProxyTest {
	public static void main(String[] args) {
		SchoolGirl mm = new SchoolGirl("Cindy");
		PursuitProxy pursuitProxy = new PursuitProxy(mm);
		pursuitProxy.giveChocolate();
	}
}
