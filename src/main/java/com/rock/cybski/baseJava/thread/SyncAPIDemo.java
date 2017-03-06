package com.rock.cybski.baseJava.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 将集合与Map转换为线程安全的
 * ArrayList, LinkedList, HashSet, HashMap
 * 都不是线程安全的，多线程情况下操作他们都会产生线程安全问题
 * 用Collections工具类将上述数据结构转换为线程安全的
 * 
 * ！遍历与存取之间没有互斥性！
 * 
 * @author rockcybski
 * 
 */
public class SyncAPIDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		/*
		 * Collections.synchronizedList(...)
		 * 该静态方法用于将给定的List集合转换为一个线程安全的List
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		/*
		 * HashSet也不是线程安全的，以此类推Map等
		 */
		Set<String> set = new HashSet<String>(list);
		set = Collections.synchronizedSet(set);
	}
}
