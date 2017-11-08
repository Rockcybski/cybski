package com.rock.cybski.baseJava;

public class ThreadTest2 {
	public static void main(String[] args) {
		P p = new P();
		Thread r1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
//					synchronized (p) {
						p.setX(1);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(p.getX() == 1);
//					}
				}
			}
		});
		Thread r2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
//					synchronized (p) {
						p.setX(2);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(p.getX() == 2);
//					}
				}
			}
		});
		r1.start();
		r2.start();
	}
}

//class P{
//	private int x = 1;
//	public int getX() {
//		return x;
//	}
//	public void setX(int x) {
//		this.x = x;
//	}
//}

class P{
	//通过使用ThreadLocal保证线程封闭性
	private ThreadLocal<Integer> x = new ThreadLocal<>();
	public int getX() {
		return x.get();
	}
	public void setX(Integer i) {
		x.set(i);
	}
}