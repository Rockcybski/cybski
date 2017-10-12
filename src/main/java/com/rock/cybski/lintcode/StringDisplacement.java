package com.rock.cybski.lintcode;

/*
 * 给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。置换的意思是，通过改变顺序可以使得两个字符串相等。
 */
public class StringDisplacement {
	/*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
	public boolean Permutation(String A, String B) {
		if (A == null || B == null) {
			return false;
		}
		if (A == B) {
			return true;
		}
		if (A.equals(B)) {
			return true;
		}
		if (A.length() != B.length()) {
			return false;
		}
		char[] aArr = A.toCharArray();
		char[] bArr = B.toCharArray();
		sort(aArr);
		sort(bArr);
		for (int i = 0; i < aArr.length; i++) {
			if (aArr[i] != bArr[i]) {
				return false;
			}
		}
		return true;
	}

	private char[] sort(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}
