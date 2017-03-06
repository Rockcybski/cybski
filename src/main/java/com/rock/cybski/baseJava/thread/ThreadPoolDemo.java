package com.rock.cybski.baseJava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 通常池的概念是为了解决两个问题
 * １）重用，２）控制数量
 * 所以线程池是为了解决
 * １）重用线程，２）控制线程数量
 * 
 * 当我们的程序需要频繁创建线程和销毁线程时，就应当考虑用线程池来维护
 * 
 * @author rockcybski
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		/*
		 * ExecutorService线程池
		 * 创建一个固定大小的线程池，线程数为2
		 */
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
						Thread t = Thread.currentThread();
						System.out.println(t+"正在运行任务");
						Thread.sleep(5000);
						System.out.println(t+"完成任务");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			threadPool.execute(r);
		}
		threadPool.shutdown();
	}
}
