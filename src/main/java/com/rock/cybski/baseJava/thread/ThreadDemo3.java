package com.rock.cybski.baseJava.thread;

/**
 * 使用匿名内部类的形式创建线程
 * @author rockcybski
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("111");
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("222");
				}
			}
		};
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("333");
				}
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("444");
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
