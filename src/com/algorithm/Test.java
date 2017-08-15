package com.algorithm;

import com.algorithm.util.SortTestHelper;

public class Test {
	public static void main(String[] args) {
		Integer arrSize = 10000;
		Integer[] randomArr = SortTestHelper.generateRandomArr(arrSize, 0, 10000);
		Integer[] randomArr2 = new Integer[arrSize];
		System.arraycopy(randomArr, 0, randomArr2, 0, arrSize);
		SortTestHelper.testSoted("com.algorithm.sort.SelectSort", randomArr);
		SortTestHelper.testSoted("com.algorithm.sort.InsertionSort", randomArr2);
	}

}
