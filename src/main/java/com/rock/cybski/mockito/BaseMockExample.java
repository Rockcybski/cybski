//package com.rock.cybski.mockito;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.LinkedList;
//
//import org.junit.Test;
//
//public class BaseMockExample {
//	
//	@Test
//	public void verifyMockedObject(){
//		// mock creation 创建mock对象
//		Foo mockedList = mock(Foo.class);
//
//		 //using mock object 使用mock对象
//		 mockedList.setKey("one");
//		 mockedList.getKey();
//
//		 //verification 验证：以下2个方法都调用了一次
//		 verify(mockedList).setKey("one");
//		 verify(mockedList).getKey();
//	}
//	
//	private class Foo{
//		private String key;
//		public String getKey() {
//			return key;
//		}
//		public void setKey(String key) {
//			this.key = key;
//		}
//	}
//	
//	@SuppressWarnings("rawtypes")
//	@Test
//	public void verifyMockedObject2(){
//		//You can mock concrete classes, not only interfaces
//		 // 你可以mock具体的类型,不仅只是接口
//		 LinkedList mockedList = mock(LinkedList.class);
//
//		 //stubbing
//		 // 测试桩
//		 when(mockedList.get(0)).thenReturn("first");
//		 when(mockedList.get(1)).thenThrow(new RuntimeException());
//
//		 //following prints "first"
//		 // 输出“first”
//		 System.out.println(mockedList.get(0));
//
//		 //following throws runtime exception
//		 // 抛出异常
//		 try{
//			 mockedList.get(1);
//		 } catch (Exception e){
//			 System.out.println(e.toString());
//		 }
//
//		 //following prints "null" because get(999) was not stubbed
//		 // 因为get(999) 没有打桩，因此输出null
//		 System.out.println(mockedList.get(999));
//
//		 //Although it is possible to verify a stubbed invocation, usually it's just redundant
//		 //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
//		 //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
//		 // 验证get(0)被调用的次数
//		 verify(mockedList).get(0);
//	}
//}
