package com.rock.cybski.baseJava.thread;
/**
 * synchronized体现的互斥性
 * 当一个对象的两个方法都被synchronized修饰，则这两个方法就有了互斥性
 * 当synchronized块包含了两段不同的代码，而这两个块对象相同，则这两段代码也有互斥性
 * @author rockcybski
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		final Foo foo = new Foo();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				foo.methodA();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				foo.methodB();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized void methodA(){
		try {
			Thread t = Thread.currentThread();
			System.out.println(t+"正在调用A方法");
			Thread.sleep(5000);
			System.out.println(t+"执行完A方法");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB(){
		try {
			Thread t = Thread.currentThread();
			System.out.println(t+"正在调用B方法");
			Thread.sleep(5000);
			System.out.println(t+"执行完B方法");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
