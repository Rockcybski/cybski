package com.rock.cybski.hadoop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.StringUtils;

public class HadoopTest {
	public static void main(String[] args) throws IOException {
		IntWritable writable = new IntWritable();
		writable.set(163);
		byte[] b = HadoopTest.serialize(writable);
		System.out.println(StringUtils.byteToHexString(b));
		IntWritable writable2 = new IntWritable();
		HadoopTest.deserialize(writable2, b);
		System.out.println(writable2.get());
	}
	
	public static byte[] serialize(Writable writable) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);
		writable.write(dataOut);
		dataOut.close();
		return out.toByteArray();
	}
	
	public static byte[] deserialize(Writable writable, byte[] bytes) throws IOException{
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		DataInputStream dataIn = new DataInputStream(in);
//		System.out.println(dataIn.readInt());
		writable.readFields(dataIn);
		return bytes;
	}
}
