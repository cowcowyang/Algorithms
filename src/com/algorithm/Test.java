package com.algorithm;

import com.algorithm.util.SortTestHelper;

public class Test {
	public static void main(String[] args) {
		SortTestHelper.testSoted("com.algorithm.sort.SelectSort", SortTestHelper.generateRandomArr(1000, 0, 1001));
	}

}
