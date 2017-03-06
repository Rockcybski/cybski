package com.rock.cybski.baseJava.thread;
/**
 * 守护线程，又叫后台线程
 * 使用上与前台线程没有区别，唯一在结束上有区别
 * 当进程结束时，无论后台线程是否还在运行都要强制结束
 * @author rockcybski
 *
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		
		/*
		 *rose:前台线程 
		 */
		Thread rose = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<5;i++){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose:AAAAAAAAAaaaaaa.......");
				System.out.println("rose - Into water, Die");
			}
		};
		
		Thread jack = new Thread(){
			@Override
			public void run() {
				while(true){
					System.out.println("jack:you jump, I jump");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		rose.start();
		
		//设置jack为守护线程，所有前台线程结束时，结束守护线程
		jack.setDaemon(true);
		jack.start();
		
		/*
		 * GC就是运行在一个守护线程上的
		 */
	}
}
