package com.rock.cybski.baseJava.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL (Uniform Resource Locator) 统一资源定位符，表示Internet上某一资源的地址
 * URL 由两部分组成：协议名称和资源名称，中间用冒号隔开
 * java。net 包中，提供了URL类来表示URL
 */

public class URLTest {
	public static void main(String[] args) {
		try {
			readURL();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用URL读取页面内容
	 * 
	 * @throws IOException
	 */
	public static void readURL() throws IOException {
		URL url = new URL("http://www.baidu.com");
		// 通过URL的openStream获取URL对象所表示的资源的字节输入流
		InputStream is = url.openStream();
		// 将字节输入流转换为字符输入流
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		// 为字符输入流添加缓冲
		BufferedReader br = new BufferedReader(isr);

		String data = br.readLine();// 读取数据
		while (data != null) {// 循环读取
			System.out.println(data);
			data = br.readLine();
		}
		br.close();
		isr.close();
		is.close();
	}

	public static void createURL() throws MalformedURLException {
		// 创建URL的实例
			URL imooc = new URL("http://www.imooc.com");
			// ?后面表示参数， #后面表示锚点
			URL url = new URL(imooc, "/index.html?username=tom#test");
			System.out.println("Protocol:" + url.getProtocol());
			System.out.println("Host:" + url.getHost());
			// 如果未指定端口号，则使用默认端口号，此时getPort()方法返回值为-1
			System.out.println("Port:" + url.getPort());
			System.out.println("FilePath:" + url.getPath());
			System.out.println("FileName:" + url.getFile());
			System.out.println("相对路径:" + url.getRef());
			System.out.println("查询字符串:" + url.getQuery());
	}
}
