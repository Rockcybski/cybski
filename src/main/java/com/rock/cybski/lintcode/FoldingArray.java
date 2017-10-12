package com.rock.cybski.lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoldingArray {
	/*
	 * Given an array nums of length n and an array req of length k , you need to fold the array as required, and output the result of the fold.
		1.If req[i] = 0 means you should fold from left to right
		for example:
		
		1 2 3 4 5 6 7 8  ==>   4 3 2 1
		                       5 6 7 8
		                       
		2.If req[i] = 1 means you should fold from right to left
		for example:
		
		1 2 3 4 5 6 7 8  ==>   8 7 6 5
		                       1 2 3 4
		More example:
		
		fold from left to right
		4 3 2 1  ==>  6 5
		5 6 7 8       3 4
		              2 1
		              7 8
				
		fold from right to left
		6 5  ==>   8
		3 4        1
		2 1        4
		7 8        5
		           6
		           3
		           2
		           7 

		Note:
		n is power of two.
		k is index.(e.g. n = 2^3 = 8��k = 3)
		
		Given array nums = [1, 2, 3, 4, 5, 6, 7, 8] and array req = [0, 0, 1]
		change array in place to be [8, 1, 4, 5, 6, 3, 2, 7]
	 * 
     * @param : the original array
     * @param : the direction each time
     * @return: the final folded array 
     */
    public static int[] folding(int[] nums, int[] req) {
    	/*
    	 	nums.length = 8
			req.lenght = 3
			for(i=0;i<req.length;i++){
				x = Math.pow(2, i+1)
				x determine the changing pairs
				when i = 0, x = 2, so nums will be split to 2 groups, based on direction, one will keep order but put to end half, 
				one will reverse its members and  then put to front half(for group, previous front group will be at back).
			}
    	 */
    	//assert nums and req are matching requirement condition
		int numsLength = nums.length;
		int halfNumsLength = nums.length / 2;
		// for temporarily put folding array, then set back to original array
		List<Integer> frontHalfTempArr = new ArrayList<>(halfNumsLength);
		List<Integer> endHalfTempArr = new ArrayList<>(halfNumsLength);
		for (int i = 0; i < req.length; i++) {
			int x = (int) Math.pow(2, i + 1);
			int direction = req[i];
			int directionChangeIndex = numsLength / x;
			for (int j = 0; j < numsLength; j++) {
				if (direction == 0) {
					frontHalfTempArr.add(nums[j]);
				} else {
					endHalfTempArr.add(nums[j]);
				}
				if ((j + 1) % directionChangeIndex == 0) {
					direction = switchDirection(direction);
				}
			}
			Collections.reverse(frontHalfTempArr);
			frontHalfTempArr.addAll(endHalfTempArr);
			for (int k = 0; k < frontHalfTempArr.size(); k++) {
				nums[k] = frontHalfTempArr.get(k);
			}
			frontHalfTempArr.clear();
			endHalfTempArr.clear();
		}
		return nums;
    }
    
    public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] req = {0, 0, 1};
		int[] result = folding(nums, req);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i] + ", ");
		}
	}
    
    private static int switchDirection(int direction) {
    	return direction == 0 ? 1 : 0;
    }
}
