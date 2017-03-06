package com.rock.cybski.baseJava.javaIO;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		//File file = new File("f:\\hero");
		File file = new File("f:"+File.separator+"hero");//用File.separator保证兼容性
		
		if(!file.exists()){
			file.mkdir();//create directory 如果多级目录 file.mkdirs()
		}else{
			file.delete();//delete
		}
		
		file.isDirectory();
		file.isFile();
	}
}
