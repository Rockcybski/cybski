package com.rock.cybski.baseJava.thread;
/**
 * 静态方法被synchronized修饰后，该静态方法变为同步的
 * 静态方法与对象无关，和类相关
 * @author rockcybski
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo b1 = new Boo();
		final Boo b2 = new Boo();
		Thread t1 = new Thread(){
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				b1.method(); //Just for demo, should be Boo.method()
			}
		};
		Thread t2 = new Thread(){
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				b2.method();//Just for demo, should be Boo.method()
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized static void method(){
		try {
			Thread t = Thread.currentThread();
			System.out.println(t+"调用了method");
			Thread.sleep(5000);
			System.out.println(t+"调用完method");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}