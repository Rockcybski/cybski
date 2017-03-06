package com.rock.cybski.baseJava.javaIO;

import java.io.File;
import java.io.IOException;

import com.rock.cybski.util.IOUtil;



public class IOUtilTest {
	public static void main(String[] args) throws IOException {
//		try {
//			IOUtil.printHexByByteArray("f:\\hero.java");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		IOUtil.copyFileByBuffer(new File("f:\\Hero.java"), new File("f:\\Hero1.java"));
	}
}
