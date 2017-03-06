package com.rock.cybski.baseJava.thread;

/**
 * Object上定义了两个方法，wait，notify
 * 当一个线程调用了一个对象的wait方法后，该线程就进入了阻塞状态，直到这个对象的notify方法
 * 被调用，才会接触阻塞
 * 使用这两个方法完成线程同步操作的即时性更强，join必须等到线程工作完毕才可以，即时性较差
 * 
 * 当调用某个对象的wait，notify方法时，需要对此对象使用synchronized块进行同步
 * 
 * @author rockcybski
 *
 */
public class ThreadDemo10 {
	private static boolean isFinish = false;
	private static Object obj = new Object();
	
	public static void main(String[] args) {
		final Thread download = new Thread(){
			@Override
			public void run() {
				System.out.println("Download: start...");
				for(int i=1;i<100;i++){
					System.out.println(i+"%...");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Download: finish!");
				isFinish = true;
				/*
				 * 当下载数据完毕，就可以通知show线程开始工作
				 */
				synchronized (obj) {
					obj.notify();
				}
				
				System.out.println("Download Apendix: start...");
				for(int i=1;i<10;i++){
					System.out.println(i*10+"%...");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Download Apendix: finish!");
			}
		};
		
		Thread show = new Thread(){
			@Override
			public void run() {
				try {
					/*
					 * 当show线程执行到这句话，就进入阻塞状态，直到obj的notify方法被调用
					 */
					synchronized (obj) {
						obj.wait();
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Start showing downloaded data...");
				if(!isFinish){
					throw new RuntimeException("Data is not complete!");
				}
				System.out.println("Show Data Complete");
			}
		};
		download.start();
		show.start();
	}
}
