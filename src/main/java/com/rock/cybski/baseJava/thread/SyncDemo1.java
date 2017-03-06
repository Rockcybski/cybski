package com.rock.cybski.baseJava.thread;
/**
 * 当多个线程同时操作一个数据时，由于线程切换的不确定性，可能会导致出现逻辑混乱，严重时
 * 可能会导致系统崩溃
 * 
 * 1) synchronized关键字修饰方法
 * 
 * @author rockcybski
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				while(true){
					int bean = table.getBean();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				while(true){
					int bean = table.getBean();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Table{
	private int beans = 20;
	/*
	 * 用synchronized关键字修饰方法，是给所属的对象加锁 （此例中为main方法中定义的table对象
	 * 当修饰了方法，该方法就是“同步”方法，多个线程不能同时访问方法内部，必须排队
	 * 解决了多个线程同时操作同一数据导致的混乱问题
	 */
	public synchronized int getBean(){
		if(beans == 0){
			throw new RuntimeException("No more beans");
		}
		Thread.yield();//此处模拟CPU时间片用完，切换线程
		return beans--;
	}
}
