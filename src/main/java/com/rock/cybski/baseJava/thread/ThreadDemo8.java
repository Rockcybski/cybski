package com.rock.cybski.baseJava.thread;

import java.text.SimpleDateFormat;

/**
 * Thread提供了一个静态方法sleep
 * 用于让运行sleep的线程进入阻塞状态指定毫秒
 * 当超时后，该线程会自动回到runnable状态等待分配CPU时间片再次运行
 * @author rockcybski
 *
 */
public class ThreadDemo8 {
	public static void main(String[] args) {
		/*
		 * 实现电子表功能 (有误差)
		 * 每秒钟输出一次当前系统时间(使用main线程)
		 * HH:MM:SS
		 */
		while(true){
			showTime();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void showTime(){
		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(time));
	}
}
