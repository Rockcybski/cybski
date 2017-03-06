package com.rock.cybski.baseJava.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Client login function based on UDP
 * @author rockcybski
 *
 */
public class UDPClientDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * Send data to servier
		 */
		//1. Define the address, port, data of server
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8088;
		byte[] data = "User:admin, Password:123".getBytes();
		//2. Create DatagramPacket
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		//3. Create DatagramSocket
		DatagramSocket socket = new DatagramSocket();
		//4. Send info to server
		socket.send(packet);
		
		/*
		 * Receive response from server
		 */
		//1. Create DatagramPacket, use to receive data
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		//2. Receive response from server
		socket.receive(packet2);
		//3. Read data
		String response = new String(data2, 0, packet2.getLength());
		System.out.println("This is client, server said:" + response);
		//4. close resource
		socket.close();
	}
}
