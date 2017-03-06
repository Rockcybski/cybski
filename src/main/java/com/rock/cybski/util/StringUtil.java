package com.rock.cybski.util;

/**
 * <strong>StringUtil</strong>
 * 
 * @author Rock Zhang
 * @version 1.0
 */
public class StringUtil {
	
	/**
	 * Find the longest common substring of 2 Strings
	 * 
	 * @param str1
	 * @param str2
	 * @return commonString, the common part of str1 and str2
	 */
	public static String searchCommonString(String str1, String str2) {
		String temp = "";
		String commonString = "";
		if (str1.length() > str2.length()) {
			temp = str1;
			str1 = str2;
			str2 = temp;
		}
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 0; j <= str1.length() - i; j++) {
				temp = str1.substring(j, j + i);
				if (str2.contains(temp)) {
					if (temp.length() > commonString.length()) {
						commonString = temp;
					}
				}
			}
		}
		return commonString;
	}
	
	/**
	 * Find the longest common substring of a String array
	 * 
	 * @param strs
	 * @return commonString
	 */
	public static String searchCommonString(String[] strs) {
		String commonString = "";
		for (int i = 1; i < strs.length; i++) {
			if (i == 1) {
				commonString = StringUtil.searchCommonString(strs[0], strs[1]);
			} else {
				commonString = StringUtil.searchCommonString(commonString,
						strs[i]);
			}
		}
		return commonString;
	}
}
