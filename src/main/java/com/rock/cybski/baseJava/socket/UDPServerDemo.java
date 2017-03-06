package com.rock.cybski.baseJava.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Server, login function based on UDP
 * @author rockcybski
 *
 */
public class UDPServerDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * Receive the data from client
		 */
		//1. Create DatagramSocket, assign port
		DatagramSocket socket = new DatagramSocket(8088);
		//2. Create DatagramPacket, use to receive data from client
		byte[] data = new byte[1024];//Create byte[], assign the size of DatagramPacket will be received
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//3. Receive the data from client
		socket.receive(packet);//Before receive the data from client, will always be blocked
		//4. Read data
		String info = new String(data,0,packet.getLength());
		System.out.println("This is server, client said:"+info);
		
		/*
		 * Response to client
		 */
		//1. Define the addres, port, data for client
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "Welcome".getBytes();
		//2. Create DatagramPacket
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
		//3. Response client
		socket.send(packet2);
		//4. close resource
		socket.close();
	}
}
