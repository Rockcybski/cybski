package com.rock.cybski.baseJava.thread;
/**
 * 获取线程状态信息的相关方法
 * @author rockcybski
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		
		long id = t.getId();
		String name = t.getName();
		int priority = t.getPriority();
		t.isAlive();
		t.isDaemon(); //时候是守护线程，后台线程
		t.isInterrupted();
		
		System.out.println("ID:"+id);
		System.out.println("Name:"+name);
		System.out.println("Priority:"+priority);
	}
}
