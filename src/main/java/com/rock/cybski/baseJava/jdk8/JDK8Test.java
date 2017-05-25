package com.rock.cybski.baseJava.jdk8;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JDK8Test {
	 public static void main(String[] args) {
		
//		interfaceTest();
		
		dateTimeTest();
		 
	 }
	 
	 public static void interfaceTest(){
		 JDK8Interface.staticPrint();
		 new JDK8InterfaceTest().defaultPrint();
		 new JDK8InterfaceTest().print();
	 }
	 
	 
	 public static void streamTest(){
		 List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
			System.out.println("求和：" + nums.stream()// 转成Stream
					.filter(team -> team != null)// 过滤
					.distinct()// 去重
					.mapToInt(num -> num * 2)// map操作
					.skip(2)// 跳过前2个元素
					.limit(4)// 限制取前4个元素
					.peek(System.out::println)// 流式处理对象函数
					.sum());//
		 
		 String mails = "a;b,c,c;d;e;e;f,g";
			Arrays.asList(mails.split(",|;")).parallelStream()
				.filter(s -> !"d".equals(s))
				.distinct()
				.skip(1)
				.forEach(str -> System.out.print(str+ " "));
	 }
	 
	 public static void lambdaTest(){
		 List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		 list.forEach(System.out::println);
		 list.forEach(e -> System.out.println("方式二："+e));
	 }
	 
	 public static void dateTimeTest(){
		          //1.Clock
		          final Clock clock = Clock.systemUTC();
		          System.out.println( clock.instant() );//2017-05-25T02:24:16.386Z
		          System.out.println( clock.millis() );//1495679056453
		          
		          //2. ISO-8601格式且无时区信息的日期部分
		          final LocalDate date = LocalDate.now();
		          final LocalDate dateFromClock = LocalDate.now( clock );
		                   
		          System.out.println( date );//2017-05-25
		          System.out.println( dateFromClock );//2017-05-25
		                   
		          // ISO-8601格式且无时区信息的时间部分
		          final LocalTime time = LocalTime.now();
		          final LocalTime timeFromClock = LocalTime.now( clock );
		                   
		          System.out.println( time );//10:24:16.654
		          System.out.println( timeFromClock );//02:24:16.654
		          
		          // 3.ISO-8601格式无时区信息的日期与时间
		          final LocalDateTime datetime = LocalDateTime.now();
		          final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );
		                   
		          System.out.println( datetime );//2017-05-25T10:24:16.654
		          System.out.println( datetimeFromClock );//2017-05-25T02:24:16.654
		          
		          // 4.特定时区的日期/时间，
		          final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		          final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
		          final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
		                   
		          System.out.println( zonedDatetime );//2017-05-25T10:24:16.655+08:00[Asia/Shanghai]
		          System.out.println( zonedDatetimeFromClock );//2017-05-25T02:24:16.655Z
		          System.out.println( zonedDatetimeFromZone );//2017-05-24T19:24:16.657-07:00[America/Los_Angeles]
		          
		          //5.在秒与纳秒级别上的一段时间
		          final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
		          final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
		           
		          final Duration duration = Duration.between( from, to );
		          System.out.println( "Duration in days: " + duration.toDays() );//Duration in days: 365
		          System.out.println( "Duration in hours: " + duration.toHours() );//Duration in hours: 8783
		      }
	 
	public void testParallel() {
		long[] arrayOfLong = new long[20000];
		// 1.给数组随机赋值
		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
		// 2.打印出前10个元素
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		// 3.数组排序
		Arrays.parallelSort(arrayOfLong);
		// 4.打印排序后的前10个元素
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
	}
}

class JDK8InterfaceTest implements JDK8Interface{
	@Override
	public void print() {
		System.out.println("regular method");
	}
}