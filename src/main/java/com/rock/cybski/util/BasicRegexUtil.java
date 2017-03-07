package com.rock.cybski.util;

import java.util.regex.Pattern;

import org.springframework.util.Assert;

public class BasicRegexUtil {
	/*
	 * . means any char
	 * \d means number, equals [0-9]
	 * \w means letter+number, equals [a-zA-Z0-9]
	 * \s means blank, equals [\t\n\x0B\f\r]
	 * \D means not number, equals [^\d] or [^0-9]
	 * \W means [^\w]
	 * \S means [^\s]
	 * 
	 * X? means 0 or 1 X
	 * X* means 0 or more X
	 * X+ means 1 or more X
	 * X{n} means n X
	 * X{n,} means n or more X
	 * X{n, m} means n-m X
	 * 
	 * boundary matching
	 * ^ means start, $ means end
	 */
	public static final String NUMBER = "\\d"; //[0-9]
	public static final String NOT_NUMBER = "\\D"; //[^0-9], not 0-9
	public static final String CHARACTER = "\\w"; //single character, [a-zA-Z0-9]
	public static final String NOT_CHARACTER = "\\W"; //[^a-zA-Z0-9]
	public static final String BLANK = "\\s"; //blank, [\t\n\x0B\f\r]
	public static final String NOT_BLANK = "\\S";//not blank, [^\s]
	public static final String CHINESE_PHONE_NUMBER = "(\\+86|0086)?\\s?1\\d{10}";
	
	public static boolean checkChinesePhoneNumber(String number){
		Assert.notNull(number);
		return Pattern.matches(CHINESE_PHONE_NUMBER, number);
	}
}
