package com.rock.cybski.baseJava.thread;

/**
 * 线程，用来解决“同时”做多个任务
 * 没有绝对意义上的同时干， 线程都是走走停停的并发运行
 * 但要表现的作用是“各干各的”
 * 线程有两种创建方式
 * 1）继承Thread类并重写run方法
 * 	第一种创建方式存在的两个明显的不足：
 * 	a: 由于java是单继承，导致如果继承Thread，就不能再继承其他父类
 * 	b: 由于线程要执行的任务被定义在线程的run方法中，导致线程与其要执行
 * 		的任务有强耦合关系，不利于线程的重用
 * 		最好的状态是，线程只负责并发运行，给什么任务就运行什么任务
 * 	优点：创建简单，使用匿名内部类创建时建议使用该方法
 * 
 * @author rockcybski
 *
 */
public class ThreadDemo1{
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 启动线程不要调用run方法，而是应当调用start方法，只有这样该线程才会被
		 * 纳入线程调度，具有并发运行的能力
		 * 
		 * start方法会很快执行完毕，并不是start方法执行的过程中run方法被执行了
		 * 而是start方法执行后，当线程第一次获取时间片是开始运行run方法
		 * 
		 * 线程不能控制什么时候获取CPU的时间片， 也不能决定是时间片的长短，这些都是由线程
		 * 调度管理，它会尽可能的均匀的将时间片分配个每一个线程，但也不保证一个线程一次这样交替分配
		 */
		t1.start();
		t2.start();
	}
}

/**
 * Extends Thread 才被认为是一个线程
 * @author rockcybski
 *
 */
class MyThread1 extends Thread{
	/**
	 * 重写run方法，并在其中定义该线程要执行的任务逻辑代码
	 */
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
}

class MyThread2 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的。");
		}
	}
}