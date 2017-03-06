package com.rock.cybski.baseJava.sort;

import java.util.Arrays;

/**
 * 1000个正整数字，2个相同，998个不同，用二分查找法找出相同的数字
 */
public class BinaryFind {
	
	public static int findSameNumber(int[] numbers){
		int[] temp = numbers.clone();
		Arrays.sort(temp);
		for(int i = 0; i<temp.length;i++){
			int target = temp[i];
			temp[i] = 0;
			int index = binaryFind(temp, target);
			if(index != -1){
				return temp[index];
			}
		}
		return -1;
	}
	
	/**
	 * 二分查找算法实现
	 * @param data 数据集合 (需要排序过）
	 * @param target 要搜索的数据
	 * @return 找到目标的位置，未找到为返回-1
	 */
	public static int binaryFind(int[] data, int target) {
		int start = 0;
		int end = data.length - 1;
		while (start <= end) {
			int middleIndex = (start + end) / 2;
			if (target == data[middleIndex]) {
				return middleIndex;
			}
			if (target >= data[middleIndex]) {
				start = middleIndex + 1;
			} else {
				end = middleIndex - 1;
			}
		}
		return -1;
	}
	
	//测试
	public static void main(String[] args) {
		int[] a = new int[1000];
		for(int i=0;i<1000;i++){
			a[i] = i+1;
		}
		a[999] = 567;
		System.out.println(findSameNumber(a));
	}
}
