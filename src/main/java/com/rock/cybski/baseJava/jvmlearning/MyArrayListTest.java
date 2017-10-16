package com.rock.cybski.baseJava.jvmlearning;

import java.util.Iterator;

public class MyArrayListTest {
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		for (int i = 1; i < 22; i++) {
			list.add(i);
		}
//		list.add(100, 1); outOfBound
		System.out.println(list.get(10));
		list.set(10, 100);
		System.out.println(list.get(10));
		list.remove(10);
		System.out.println(list.get(10));
		list.forEach(x -> System.out.print(x + " | "));
		System.out.println();
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer val = iterator.next();
			System.out.print(val + " | ");
			if (val % 2 == 0) {
				iterator.remove();
			}
		}
		System.out.println();
		list.forEach(x -> System.out.print(x + " | "));
		list.clear();
		System.out.println();
	}
}
