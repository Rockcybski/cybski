package com.rock.cybski.leetcode_lintcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个列表，该列表中的每个要素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。
 * 给定 [1,2,[1,2]]，返回 [1,2,1,2]。 给定 [4,[3,[2,[1]]]]，返回 [4,3,2,1]。
 */
public class FlattenList {
	// @param nestedList a list of NestedInteger
    // @return a list of integer
    @SuppressWarnings("unchecked")
	public List<Integer> flatten(List<NestedInteger> nestedList) {
    	//TODO bad performance, can't pass leetcode test due to time
        List<Integer> resultList = new ArrayList<>();
        Boolean stillIncludeList = true;
        Object[] result = new Object[2];
		do {
			result = doFlatten(nestedList);
			stillIncludeList = (Boolean) result[1];
			nestedList = (List<NestedInteger>) result[0];
		} while (stillIncludeList);
		if (result[0] instanceof ArrayList<?>) {
			for (int i = 0; i < ((ArrayList<NestedInteger>) result[0]).size(); i++) {
				resultList.add(((ArrayList<NestedInteger>) result[0]).get(i).getInteger());
			}
		}
		return resultList;
    }
    
    private Object[] doFlatten(List<NestedInteger> nestedList) {
    	Boolean stillIncludeList = false;
    	List<NestedInteger> resultList = new ArrayList<>();
    	for(NestedInteger item:nestedList) {
    		if(item.isInteger()){
    			resultList.add(item);
    		}else {
    			stillIncludeList = true;
    			resultList.addAll(item.getList());
    		}
    	}
    	Object[] result = new Object[2];
    	result[0] = resultList;
    	result[1] = stillIncludeList;
    	return result;
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer,
	// rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds,
	// if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds,
	// if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

