package com.rock.cybski.baseJava.javaIO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.rock.cybski.util.IOUtil;



public class DataOutputStreamDemo {
	public static void main(String[] args) throws IOException{
		String file = "demo/dos.dat";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		//use utf-8
		dos.writeUTF("你好");
		//use utf-16be
		dos.writeChars("你好");
		dos.close();
		IOUtil.printHex(file);
	}
}
