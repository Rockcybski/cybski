package com.rock.cybski.baseJava.javaIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BufferedReaderAndBufferedWriterOrPrinterWriter {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("demo\\output.txt")));

//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
//				new FileOutputStream("demo\\bw.txt")));
		
		PrintWriter pw = new PrintWriter("demo\\pw.txt");
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line); // line doesn't inlcude "\n"
//			bw.write(line);
//			bw.newLine(); // new line
//			bw.flush();
			pw.println(line);
			pw.flush();
		}
		br.close();
//		bw.close();
		pw.close();
	}
}
