package com.rock.cybski.baseJava;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

import org.junit.Test;

public class ReferenceTest {

	@Test
	public void strongReference() {
		Object referent = new Object();
		
		/**
		 * 通过赋值创建 StrongReference
		 */
		Object strongReference = referent;
		
		assertSame(referent, strongReference);

		referent = null;
		
		System.gc();

		/**
		 * StrongReference 在 GC 后不会被回收
		 */
		assertNotNull(strongReference);
	}
	
	@Test
	public void softReference() {
		Object referent = new Object();
		
		SoftReference<Object> softReference = new SoftReference<Object>(referent);
		
		assertSame(referent, softReference.get());
		
		referent = null;
		
		System.gc();
		
		/*
		 * SoftReference 只在jvm OutOfMemory前才会被回收
		 */
		assertNotNull(softReference.get());
	}
	
	@Test
	public void weakReference() {
		Object referent = new Object();
		
		WeakReference<Object> weakReference = new WeakReference<Object>(referent);
		
		assertSame(referent, weakReference.get());
		
		referent = null;
		
		System.gc();
		
		/*
		 * 当对象只有弱引用时，将在下一次GC被回收
		 */
		assertNull(weakReference.get());
	}
	
	/*
	 * WeakHashMap 使用 WeakReference 作为 key， 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
	 */
	@Test
	public void weakHashMap() throws InterruptedException {
		Map<Object, Object> weakHashMap = new WeakHashMap<Object, Object>();
		Object key = new Object();
		Object value = new Object();
		weakHashMap.put(key, value);

		assertTrue(weakHashMap.containsValue(value));

		key = null;
		System.gc();

		/**
		 * 等待无效 entries 进入 ReferenceQueue 以便下一次调用 getTable 时被清理
		 */
		Thread.sleep(1000);

		/**
		 * 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
		 */
		assertFalse(weakHashMap.containsValue(value));
	}
	
	@Test
	public void phantomReference() {
		//TODO
	}
	
}
