package com.rock.cybski.baseJava.thread;
/**
 * 线程优先级
 * 10个等级，1最低，10最高，5默认
 * 可以使用Thread提供的常量
 * MIN_PRIORITY = 1
 * MAX_PRIORITY = 10
 * NORM_PRIORITY = 5
 * 原则上，优先级高的线程被分配CPU时间片的次数多
 * @author rockcybski
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread max = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("max");
				}
			}
		};
		
		Thread min = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
			}
		};
		
		Thread norm = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("norm");
				}
			}
		};
		
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		
		max.start();
		min.start();
		norm.start();
	}
}
