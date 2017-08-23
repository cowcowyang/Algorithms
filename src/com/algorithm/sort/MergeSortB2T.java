package com.algorithm.sort;

import com.algorithm.util.SortTestHelper;

public class MergeSortB2T<T> extends AbstractSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int n = arr.length;
		for (int i = 0; i <= n; i += 16) {
			InsertionSort<T> insertionSort = new InsertionSort<>();
			insertionSort.sort(arr, i, Math.min(i + 15, n - 1));
		}

		for (int sz = 16; sz < n; sz += sz) {
			for (int i = 0; i < n - sz; i += sz + sz)
				// 对于arr[mid] <= arr[mid+1]的情况,不进行merge
				if (arr[i + sz - 1].compareTo((T) arr[i + sz]) > 0) {
					MergeSort<T> mergeSort = new MergeSort<>();
					mergeSort.merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
				}
		}
	}
	
	public static void main(String[] args) {
		Integer[] randomArr = SortTestHelper.generateRandomArr(20, 1,50);
		MergeSortB2T<Integer> mergeSortB2T = new MergeSortB2T<>();
		mergeSortB2T.sort(randomArr);
		SortTestHelper.printArr(randomArr);
		return;
	}
}
