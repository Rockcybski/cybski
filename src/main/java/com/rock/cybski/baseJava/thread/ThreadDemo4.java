package com.rock.cybski.baseJava.thread;
/**
 * Thread 提供了一个静态方法
 * static Thread currentThread()
 * 该方法用于获取运行这个方法的线程。
 * @author rockcybski
 *
 */
public class ThreadDemo4 {
	/**
	 * 进程中至少有一个前台线程，而当java虚拟机启动后就会启动一个前台线程来运行main方法
	 * 
	 * 进程结束：当一个进程中的所有前台线程都结束了进程就结束了，由于我们只有运行main方法的
	 * 只一个前台线程，所以当main方法执行完毕，该线程完成任务结束，进程中就没有前台线程了，
	 * 所以进程结束了。
	 * @param args
	 */
	public static void main(String[] args) {
		//获取运行main方法的线程
		Thread t = Thread.currentThread();
		System.out.println(t);
		
		dosome();
		
		//自定义线程
		Thread myT = new Thread(){
			@Override
			public void run() {
				dosome();
				Thread t = Thread.currentThread();
				System.out.println(t);
			}
		};
		myT.start();
	}
	
	public static void dosome(){
		//获取运行dosome方法的当前线程
		Thread t = Thread.currentThread();
		System.out.println(t);
	}
}
