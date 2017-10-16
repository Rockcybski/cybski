package com.rock.cybski.baseJava.jvmlearning;

public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add((i * i));
		}
		System.out.println(list.size());
		list.remove(5);
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}
	}
	
}