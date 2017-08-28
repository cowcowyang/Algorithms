package com.algorithm.sort;

import com.algorithm.util.SortTestHelper;

public class QuickSort<T> extends AbstractSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int n = arr.length;
		recursiveSort(arr, 0, n - 1);
	}

	// j : the index of partition element
	private void recursiveSort(Comparable<T>[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int j = partition(arr, l, r);
		recursiveSort(arr, l, j);
		recursiveSort(arr, j + 1, r);
	}

	// return the index of partition element : j
	// arr[l+1...j] < v < arr[j+1...r]
	private int partition(Comparable<T>[] arr, int l, int r) {

		Comparable<T> v = arr[l];
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (arr[i].compareTo((T) v) < 0) {
				j++;
				SortTestHelper.swap(arr, i, j);
			}
		}
		SortTestHelper.swap(arr, l, j);

		return j;
	}

	public static void main(String[] args) {
		Integer[] randomArr = SortTestHelper.generateRandomArr(10, 0, 25);
		QuickSort<Integer> quickSort = new QuickSort<>();
		quickSort.sort(randomArr);
		SortTestHelper.printArr(randomArr);
	}
}
