package com.rock.cybski.baseJava.jvmlearning;

import com.rock.cybski.baseJava.exception.UnderflowException;

public class MyBinarySearchTreeTest {
	public static void main(String[] args) {
		String[] x = {"adi", "dji", "opal", "zidlo", "mm", "mnsi", "idkai", "ididk", "aa", "ab", "ax"};
		MyBinarySearchTree<String> tree = new MyBinarySearchTree<>();
		for(String s:x) {
			tree.insert(s);
		}
		try {
			System.out.println(tree.findMin());
			System.out.println(tree.findMax());
			tree.remove("ax");
			System.out.println();
		} catch (UnderflowException e) {
			e.printStackTrace();
		}
	}
}
