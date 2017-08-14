package com.aligorithm;

import com.aligorithm.util.SortTestHelper;

public class Test {
	
	public static void main(String[] args) {
		SortTestHelper.testSoted("com.aligorithm.sort.SelectSort", SortTestHelper.generateRandomArr(1000, 0, 1001));
	}

}
