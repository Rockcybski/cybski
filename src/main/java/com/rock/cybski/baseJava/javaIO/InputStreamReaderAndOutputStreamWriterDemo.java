package com.rock.cybski.baseJava.javaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamReaderAndOutputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("d:\\status.csv");
		InputStreamReader isr = new InputStreamReader(in); //Default charset = project charset
		
		FileOutputStream out = new FileOutputStream("demo\\output.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out);
//		int c;
//		while ((c=isr.read())!=-1){
//			System.out.println((char)c);
//		}
		char[] buffer = new char[8*1024];
		int c;
		while((c=isr.read(buffer,0,buffer.length))!=-1){
			String s = new String(buffer,0,c);
			System.out.println(s);
			osw.write(buffer, 0, c);
			osw.flush();
		}
		isr.close();
		osw.close();
	}
}
