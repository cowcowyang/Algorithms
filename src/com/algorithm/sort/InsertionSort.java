package com.algorithm.sort;

import com.algorithm.util.SortTestHelper;

public class InsertionSort<T> extends AbstrctSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		for (int i = 1; i < arr.length; i++) {
//			// ver 1
//			for (int j = i; j > 0; j--) {
//				if (arr[j].compareTo((T) arr[j - 1]) < 0) {
//					SortTestHelper.swap(arr, j, j - 1);
//				}
//			}

//			// ver 2
//			for (int j = i; j > 0 && arr[j].compareTo((T) arr[j - 1]) < 0; j--) {
//				SortTestHelper.swap(arr, j, j - 1);
//			}
//
			// ver 3
			Comparable<T> e = arr[i];
			int j = i;
			for (; j > 0 && e.compareTo((T) arr[j - 1]) < 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = e;
		}
	}

	public static void main(String[] args) {
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		Integer[] randomArr = SortTestHelper.generateRandomArr(800, 1, 1000);
		SortTestHelper.printArr(randomArr);
		insertionSort.sort(randomArr);
		SortTestHelper.printArr(randomArr);
	}

}
