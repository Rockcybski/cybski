package com.rock.cybski.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
	/**
	 * 单字节读取指定文件内容， 按照16进制输出到控制台,并且每输出10个byte换行，不适合读取大文件，效率低
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHex(String fileName) throws IOException {
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		while ((b = in.read()) != -1) {
			if (b <= 0xf) {
				// 单位数前面补0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " ");
			if (i++ % 10 == 0) {
				System.out.println();
			}
		}
		in.close();
	}

	/**
	 * 批量字节读取指定文件内容， 按照16进制输出到控制台,并且每输出10个byte换行, 以InputStream.read(byte b[], int off, int len) 方法读取,适合读取大文件，常用
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray(String fileName) throws IOException {
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[8 * 1024];

		int bytes = 0;
		int j=1;
		//in.read(buf,0,buf.length) 读取到buf数组，返回读到的byte个数
		while((bytes = in.read(buf,0,buf.length))!= -1){
			for(int i=0;i<bytes;i++){
				if(buf[i]<=0xf){
					System.out.print("0");
				}
				//byte类型8位，int类型32位，为了避免数据转换错误，通过&0xff将高24位清零
				System.out.print(Integer.toHexString(buf[i] & 0xff)+" ");
				if(j++%10==0){
					System.out.println();
				}
			}
		}
		in.close();
	}
	
	/**
	 * 字节批量读取，复制文件，效率高
	 * 完全复制srcFile到destFile，注意如果destFile已存在，将被删除然后新建
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists() || !srcFile.isFile()){
			throw new IllegalArgumentException("The file doesn't exist or it's not a File.");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		
		byte[] buf= new byte[8*1024];
		int b;
		while((b=in.read(buf, 0, buf.length))!=-1){
			out.write(buf,0,b);
			out.flush();
		}
		in.close();
		out.close();
	}
	
	/**
	 * 进行文件的拷贝，利用带缓冲的字节流
	 * 完全复制srcFile到destFile，注意如果destFile已存在，将被删除然后新建
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists() || !srcFile.isFile()){
			throw new IllegalArgumentException("The file doesn't exist or it's not a File.");
		}
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		
		int c;
		while((c=bis.read())!=-1){
			bos.write(c);
			bos.flush();//刷新缓存区
		}
		bis.close();
		bos.close();
	}
	
	/**
	 * 单字节，不带缓冲进行文件拷贝
	 * 完全复制srcFile到destFile，注意如果destFile已存在，将被删除然后新建
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByByte(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists() || !srcFile.isFile()){
			throw new IllegalArgumentException("The file doesn't exist or it's not a File.");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		int c;
		while((c=in.read())!=-1){
			out.write(c);
			out.flush();
		}
		in.close();
		out.close();
	}
}
