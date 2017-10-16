package com.rock.cybski.baseJava.jvmlearning;

import java.io.Serializable;
import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E>, Serializable{
	
	private static final long serialVersionUID = -7804780989109005732L;

	private int size = 0;
	private int modCount = 0;
	private Node<E> first;
	private Node<E> last;
	
	public MyLinkedList() {
	}

	public void clear() {
		size = 0;
		modCount++;
		first = null;
		last = null;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean add(E x) {
		linkLast(x);
		return true;
	}
	
	private void linkLast(E x) {
		//record current last
		Node<E> l = last;
		//build new node, prev is current last, next is null
		Node<E> newNode = new Node<E>(x, l, null);
		//set new node as new last
		last = newNode;
		//empty list add
		if (l == null) {
			first = newNode;
		} 
		//non-empty list add
		else {
			l.next = newNode;
		}
		size++;
		modCount++;
	}
	
	private void linkBefore(Node<E> p, E x) {
		//get current prev of p
		Node<E> pred = p.prev;
		Node<E> newNode = new Node<E>(x, pred, p);
		//set p's prev
		p.prev = newNode;
		//i.e. first
		if (pred == null) {
			first = newNode;
		} else {
			pred.next = newNode;
		}
		size++;
		modCount++;
	}

	public boolean add(int index, E x) {
		rangeCheckForAdd(index);
		if(index == size) {
			linkLast(x);
		}else {
			linkBefore(node(index), x);
		}
		return true;
	}
	
	/**
	 * get node by its index
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		// index in first half
		if (index < (size >> 1)) {
			Node<E> x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node<E> x = last;
			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
	}
	
	private void rangeCheck(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Size: " + size + ", Index: " + index);
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Size: " + size + ", Index: " + index);
		}
	}
	
	public E get(int index) {
		rangeCheck(index);
		return node(index).item;
	}

	public E set(int index, E x) {
		rangeCheck(index);
		Node<E> n = node(index);
		E oldValue = n.item;
		n.item = x;
		return oldValue;
	}
	
	public E remove(int index) {
		rangeCheck(index);
		return unlink(node(index));
	}
	
	private E unlink(Node<E> p) {
		//assert p is not null and in the list
		final E item = p.item;
		final Node<E> prev = p.prev;
		final Node<E> next = p.next;
		
		//need handle p is first/last scenario
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			p.prev = null;// GC?
		}
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			p.next = null;
		}
		p.item = null;
		
		size--;
		modCount++;
		
		return item;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<E>{
		
		

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void remove() {
			//TODO
		}
		
	}
	
	private static class Node<E>{
		public E item;
		public Node<E> prev;
		public Node<E> next;
		public Node(E d, Node<E> p, Node<E> n) {
			item = d;
			prev = p;
			next = n;
		}
	}

}
