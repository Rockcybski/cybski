package com.rock.cybski.baseJava.sort;

/**
 * 选择排序
 */
public class SelectSort {
	/**
	 * 将int数组从小到大排序，使用选择排序法 即遍历数组，先将最小的放到第一位，然后继续遍历剩余的，将剩余中最小的放到第二位，以此类推，完成排序
	 * 
	 * @param numbers
	 */
	public static void selectSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < numbers.length; j++) {
				// 比较大小，用min记录最小数字index
				if (numbers[min] > numbers[j]) {
					min = j;
				}
			}
			if (min != i) {
				// 交换数字
				SortBaseUtil.swapNumInArray(numbers, min, i);
			}
		}
	}
	
	// 测试
	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = (int) (Math.random() * 100);
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(nums[i] + " ");
		}
		selectSort(nums);
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
