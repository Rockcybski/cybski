package com.rock.cybski.baseJava.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
	/**
	 * 将int数组从小到大排序
	 * 使用冒泡排序法 即遍历数组，先将最大的放到最后一位，然后继续遍历第一位到倒数第二位，将剩余中最大的放到倒数第二位
	 * 以此类推，完成排序
	 * @param numbers
	 */
	public static void bubbleSort(int[] numbers){
		for(int i=0;i<numbers.length-1;i++){
			for(int j=0;j<numbers.length-1-i;j++){
				if(numbers[j]>numbers[j+1]){
					SortBaseUtil.swapNumInArray(numbers, j, j+1);
				}
			}
		}
	}
	
	//test
	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(nums));
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
