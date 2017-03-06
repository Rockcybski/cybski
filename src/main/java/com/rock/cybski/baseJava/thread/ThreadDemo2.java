package com.rock.cybski.baseJava.thread;

/**
 * 线程创建的第二种方式
 * 2）实现Runnable接口，并重写run方法。
 * 实际上是单独定义线程要执行的任务，这里实现了一个与线程无关的接口Runnable，
 * 由于java接口可以多实现，所以并不影响再实现其他接口同时由于没有继承其他类，那么也可以自行指定父类
 * 
 * 由于单独指定了线程要执行的任务，并且在创建线程的时候将任务指派进去，而不是在线程内部定义任务
 * 这就接军了线程与任务之间的耦合关系
 * 
 * @author rockcybski
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}

class MyRunnable1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
}

class MyRunnable2 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的。");
		}
	}
}

