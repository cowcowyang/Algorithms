package com.algorithm;

import com.algorithm.util.SortTestHelper;

public class Test {
	public static void main(String[] args) {
		Integer arrSize = 100;
		Integer[] randomArr = SortTestHelper.generateRandomArr(arrSize, 0, 10000);
//
//		Integer[] randomArr2 = new Integer[arrSize];
//		System.arraycopy(randomArr, 0, randomArr2, 0, arrSize);
//		SortTestHelper.testSoted("com.algorithm.sort.ShellSort", randomArr);
//		SortTestHelper.testSoted("com.algorithm.sort.InsertionSort", randomArr2);
		
		shellSort(randomArr);
		SortTestHelper.printArr(randomArr);

	}

	private static <T> void insertionSort(Comparable<T>[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			Comparable<T> e = arr[i];
			for (; j > 0 && e.compareTo((T) arr[j - 1]) < 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = e;
		}
	}

	private static <T> void selectSort(Comparable<T>[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo((T) arr[i]) < 0) {
					minIndx = j;
					SortTestHelper.swap(arr, i, minIndx);
				}
			}
		}
	}

	private static <T> void shellSort(Comparable<T>[] arr) {

		int n = arr.length;
		// the gap
		int h = 1;
		while (h < n / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = h; i < n; i++) {
				Comparable<T> e = arr[i];
				// insertion sort
				int j = i;
				for (; j >= h && e.compareTo((T) arr[j - h]) < 0; j -= h) {
					arr[j] = arr[j - h];
				}
				arr[j] = e;
			}
			h /= 3;
		}
	}

}
