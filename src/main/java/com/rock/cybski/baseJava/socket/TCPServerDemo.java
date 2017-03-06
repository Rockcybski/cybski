package com.rock.cybski.baseJava.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 */

public class TCPServerDemo {
	public static void main(String[] args) {
		try {
			multipleClientsServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void multipleClientsServer() throws IOException{
		//1. 创建服务器端的socket，即ServerSocket，指定绑定的端口，并监听此端口
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = null;
		//记录客户端数量
		int clientCount = 0;
		System.out.println("*****服务器即将启动，等待客户端的连接****");
		while(true){//死循环，循环监听
			//调用accept（）方法开始监听，等待客户端的连接
			socket = serverSocket.accept();
			//创建一个新的线程
			ServerThread serverThread = new ServerThread(socket);
			//启动线程
			serverThread.start();
			clientCount++;
			System.out.println("客户端数量："+clientCount);
			InetAddress address = socket.getInetAddress();
			System.out.println("当前客户端："+address);
		}
	}
	
	public static void singleClientServer() throws IOException{
		//1. 创建服务器端的socket，即ServerSocket，指定绑定的端口，并监听此端口
		ServerSocket serverSocket = new ServerSocket(8888);
		//2. 调用accept（）方法开始监听，等待客户端的连接
		System.out.println("*****服务器即将启动，等待客户端的连接****");
		Socket socket = serverSocket.accept();
		//3. 获取输入流，用来读取客户端信息
		InputStream is = socket.getInputStream(); //字节流
		InputStreamReader isr = new InputStreamReader(is);//转换为字符流
		BufferedReader br = new BufferedReader(isr);//为输入流添加缓冲
		
		String info = null;
		while((info=br.readLine())!=null){
			System.out.println("我是服务器端，客户端说："+info);
		}
		//4. 获取输出流，相应客户端请求
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
		pw.write("欢迎您！");
		pw.flush();//调用方法将缓冲输出
		
		//Final. 关闭相关资源
		br.close();
		isr.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
		serverSocket.close();
	}
}

/**
 * 服务器端线程处理类
 * @author Rockcybski
 *
 */
class ServerThread extends Thread{
	Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	//线程执行的造作，响应客户端的请求
	@Override
	public void run() {
		super.run();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			//1. 获取输入流，用来读取客户端信息
			is = socket.getInputStream(); //字节流
			isr = new InputStreamReader(is);//转换为字符流
			br = new BufferedReader(isr);//为输入流添加缓冲
			
			String info = null;
			while((info=br.readLine())!=null){
				System.out.println("我是服务器端，客户端说："+info);
			}
			//2. 获取输出流，相应客户端请求
			os = socket.getOutputStream();
			pw = new PrintWriter(os);//将输出流包装为打印流
			pw.write("欢迎您！");
			pw.flush();//调用方法将缓冲输出
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//Final. 关闭相关资源
			try {
				if(br!=null){
					br.close();
				}
				if(isr!=null){
					isr.close();
				}
				if(is!=null){
					is.close();
				}
				if(pw!=null){
					pw.close();
				}
				if(os!=null){
					os.close();
				}
				if(socket!=null){
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
