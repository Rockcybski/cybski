package com.rock.cybski.baseJava.jvmlearning;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E>, Serializable {
	
	private static final long serialVersionUID = -3536567777370875260L;

	/*
	 * define the default capacity of items array
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	/*
	 * size of items array
	 */
	private int size;
	
	/*
	 * items array
	 */
	private E[] items;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		size = 0;
		items = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			items[i] = null;
		}
		size = 0;
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void trimToSize() {
		ensureCapacity(size);
	}
	
	public E get(int index) {
		rangeCheck(index);
		return items[index];
	}
	
	/*
	 * return old value at the index
	 */
	public E set(int index, E newVal) {
		rangeCheck(index);
		E oldVal = items[index];
		items[index] = newVal;
		return oldVal;
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(outOfBoundMes(index));
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(outOfBoundMes(index));
		}
	}
	
	private String outOfBoundMes(int index) {
		return "Index: " + index + ", Size: " + size;
	}
	
	/**
	 * check if the items size is bigger than new capacity, if no, increase items available size
	 * @param newCapacity
	 */
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < size) {
			return;
		}
		E[] old = items;
		items = (E[]) new Object[newCapacity];
		if (old != null) {
			items = Arrays.copyOf(old, items.length);
		}
	}
	
	public boolean add(E x) {
		add(size, x);
		return true;
	}
	
	/**
	 * check capacity
	 * for items after index, move backwards
	 * set index value
	 * @param index
	 * @param x
	 */
	public void add(int index, E x) {
		rangeCheckForAdd(index);
		// items.length = available places, size = places already with value, +1 for case when size == 0
		if (items.length == size) {
			ensureCapacity(size * 2 + 1);
		}
		for (int i = size; i > index; i--) {
			items[i] = items[i - 1];
		}
		items[index] = x;
		size++;
	}
	
	public E remove(int index) {
		E removed = items[index];
		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}
		size--;
		return removed;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<E>{
		
		private int currentIndex = 0;
		
		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return items[currentIndex++];
		}
		
		public void remove() {
			MyArrayList.this.remove(--currentIndex);
		}
	}
}
