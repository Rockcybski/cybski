package com.rock.cybski.baseJava.jvmlearning;

import java.io.Serializable;

public class MyBinarySearchTree<E extends Comparable<? super E>> implements Serializable{

	private static final long serialVersionUID = -7213064416897178005L;
	
	

}

class BinaryNode<E>{
	E element;
	BinaryNode<E> left;
	BinaryNode<E> right;
	
	BinaryNode(E element){
		this(element, null, null);
	}
	
	BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right){
		this.element = element;
		this.left = left;
		this.right = right;
	}
}
