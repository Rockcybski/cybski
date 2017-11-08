package com.rock.cybski.baseJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadTest {
    private static int i;
    public static synchronized int getI() throws InterruptedException{
    	Thread.sleep(10);
        return i++;
    }
    public static void main(String[] args){
    	for(int i=0;i<100;i++) {
    		new Thread(new MyThread()).start();
    	}
    	try {
			Thread.sleep(5000);
			System.out.println("============================");
			Collections.sort(MyThread.intList);
			System.out.println(MyThread.intList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}

class MyThread implements Runnable{

    public static List<Integer> intList;

    static{
        intList = new ArrayList<>();
    }

    @Override
    public void run() {
    	int x;
		try {
			x = ThreadTest.getI();
			System.out.println(x);
			intList.add(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}