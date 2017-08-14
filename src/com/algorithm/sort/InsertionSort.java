package com.algorithm.sort;

import com.algorithm.util.SortTestHelper;

public class InsertionSort<T> extends AbstrctSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(arr[j].compareTo((T) arr[j - 1]) < 0){
					SortTestHelper.swap(arr, j ,j - 1);
				}
			}
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
