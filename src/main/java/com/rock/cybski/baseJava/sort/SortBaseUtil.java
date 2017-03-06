package com.rock.cybski.baseJava.sort;

public class SortBaseUtil {
	public static void swapNumInArray(int[] numbers, int i, int j){
		int temp = numbers[j];
		numbers[j] = numbers[i];
		numbers[i] = temp;
	}
}
