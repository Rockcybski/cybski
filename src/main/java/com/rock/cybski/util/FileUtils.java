package com.rock.cybski.util;

import java.io.File;
import java.io.IOException;

//列出File的一些常用操作，比如过滤、遍历等操作
public class FileUtils {
	/**
	 * 列出指定目录下 （包括其子目录）的所有文件
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("Directory:"+dir+"not exist!");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"is not directory");
		}
		File[] files = dir.listFiles();//返回的是直接子目录（文件）的抽象
		if(files!=null &&files.length>0){
			for(File file:files){//递归获取所有子目录（文件）
				if(file.isDirectory()){
					listDirectory(file);
				}else{
					System.out.print(file);
				}
			}
		}
	}
}

