package com.rock.cybski.baseJava.thread;
/**
 * 线程提供了一个方法join
 * 该方法允许当前线程进入阻塞状态等待另一个线程工作完毕
 * 通常需要协调两个线程工作时使用该方法
 * @author rockcybski
 *
 */
public class ThreadDemo9 {
	
	private static boolean isFinish = false;
	
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
			}
		};
		
		Thread show = new Thread(){
			@Override
			public void run() {
				/*
				 * 在这里等待download线程先将数据下载完毕
				 * （将download线程join，show被阻塞，等待download结束后继续）
				 */
				try {
					download.join();
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
