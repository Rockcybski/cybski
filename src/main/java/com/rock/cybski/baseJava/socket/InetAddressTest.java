package com.rock.cybski.baseJava.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
 * InetAddress类, 表示互联网协议地址
 */

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		//获取本机的InetAddress实例
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("Compatur: " + address.getHostName());
		System.out.println("IP Address: " +address.getHostAddress());
		byte[] bytes = address.getAddress(); //获取字节数组形式的IP地址
		System.out.println(Arrays.toString(bytes));
		System.out.println(address);//直接输出InetAddress对象
		System.out.println();
		
		//根据机器名获取InetAddress实例
		InetAddress address2 = InetAddress.getByName("rockPC");
		System.out.println("Compatur: " + address2.getHostName());
		System.out.println("IP Address: " +address2.getHostAddress());
		System.out.println();
		
		//根据IP地址获取InetAddress实例
		address2 = InetAddress.getByName("192.168.199.168");
		System.out.println(address2);
		
	}
}
