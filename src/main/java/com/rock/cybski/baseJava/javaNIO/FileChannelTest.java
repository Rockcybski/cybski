package com.rock.cybski.baseJava.javaNIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
	public static void main(String[] args) {
		readAndWrite();
		copy();
	}

	private static void readAndWrite() {
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("demo/test.txt", "rw");
			FileChannel fileChannel = file.getChannel();
			
			//print fileChannel size
			long size = fileChannel.size();
			System.out.println("file size: " + size);
			
			//create buffer with capacity of 48 bytes
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			
			
			//write new data
			String newData = "New String data to write to file " + System.currentTimeMillis() + "\n";
			byteBuffer.clear();
			byteBuffer.put(newData.getBytes());
			
			byteBuffer.flip();
			
			//set position to end
			long position = fileChannel.position();
			fileChannel.position(position + size); 
			
			while(byteBuffer.hasRemaining()) {
				fileChannel.write(byteBuffer);
			}
			
			//read into buffer from channel
			fileChannel.position(0);//set back position to 0
			byteBuffer.clear();
			int bytesRead = fileChannel.read(byteBuffer);
			while(bytesRead != -1) {
				byteBuffer.flip(); //make buffer ready to read
				
				while(byteBuffer.hasRemaining()) {
					System.out.print((char) byteBuffer.get()); //read 1 byte at one time, print
				}
				
				byteBuffer.clear(); //make buffer ready to write
				bytesRead = fileChannel.read(byteBuffer);
			}
			
			//close channel
			fileChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void copy() {
		try {
			RandomAccessFile sourceFile = new RandomAccessFile("demo/test.txt", "rw");
			RandomAccessFile tarFile = new RandomAccessFile("demo/testCopy.txt", "rw");
			
			FileChannel sourceChannel = sourceFile.getChannel();
			FileChannel tarChannel = tarFile.getChannel();
			
			sourceChannel.transferTo(0, sourceChannel.size(), tarChannel);
			
			sourceChannel.close();
			tarChannel.close();
			sourceFile.close();
			tarFile.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
