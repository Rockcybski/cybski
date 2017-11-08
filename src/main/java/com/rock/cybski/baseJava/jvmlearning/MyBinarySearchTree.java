package com.rock.cybski.baseJava.jvmlearning;

import java.io.Serializable;

import com.rock.cybski.baseJava.exception.UnderflowException;

public class MyBinarySearchTree<E extends Comparable<? super E>> implements Serializable {

	private static final long serialVersionUID = -7213064416897178005L;

	private BinaryNode<E> root;

	public MyBinarySearchTree() {
		root = null;
	}
;
	public void empty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(E x) {
		return contains(x, root);
	}

	public E findMin() throws UnderflowException {
		if (root == null) {
			throw new UnderflowException();
		}
		return findMin(root).element;
	}

	public E findMax() throws UnderflowException {
		if (root == null) {
			throw new UnderflowException();
		}
		return findMax(root).element;
	}

	public void insert(E x) {
		root = insert(x, root);
	}

	public void remove(E x) {
		root = remove(x, root);
	}

	public void printTree() {
		printTree(root);
	}

	/*
	 * Internal method to find item in a subtree
	 */
	private boolean contains(E x, BinaryNode<E> t) {
		if (t == null) {
			return false;
		}
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0) {
			return contains(x, t.left);
		} else if (compareResult > 0) {
			return contains(x, t.right);
		} else {
			return true; // Match
		}
	}

	/*
	 * Internal method to find smallest node in a subtree
	 */
	private BinaryNode<E> findMin(BinaryNode<E> t) {
		if (t == null) {
			return null;
		}
		if (t.left == null) {
			return t;
		}
		return findMin(t.left);
	}

	private BinaryNode<E> findMax(BinaryNode<E> t) {
		if (t == null) {
			return null;
		}
		if (t.right == null) {
			return t;
		}
		return findMax(t.right);
	}

	private BinaryNode<E> insert(E x, BinaryNode<E> t) {
		if (t == null) {
			return new BinaryNode<E>(x);
		}
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0) {
			t.left = insert(x, t.left);
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
		}
		return t;
	}

	private BinaryNode<E> remove(E x, BinaryNode<E> t) {
		if(t == null) {
			return t; //x not found, do nothing
		}
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0) {
			t.left = remove(x, t.left);
		}else if(compareResult > 0) {
			t.right = remove(x, t.right);
		}else if (t.left != null && t.right != null) {//item found, but with 2 children
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		}else {//item found, only 1 child or no child
			t = t.left != null ? t.left : t.right;
		}
		return t;
	}

	private void printTree(BinaryNode<E> t) {
		//TODO
		System.out.println("Not implement yet.");
	}

	private static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		BinaryNode(E element) {
			this(element, null, null);
		}

		BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
}
