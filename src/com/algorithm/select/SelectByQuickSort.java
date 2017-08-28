package com.algorithm.select;

import com.algorithm.sort.QuickSortThreeWays;
import com.algorithm.util.SortTestHelper;

public class SelectByQuickSort<T> {

	public Comparable<T> select(Comparable<T>[] arr, int k) {
		int n = arr.length;
		assert k >= 0 && k < n;
		return select(arr, 0, n - 1, k);
	}

	private Comparable<T> select(Comparable<T>[] arr, int l, int r, int k) {
		if (l == r) {
			return arr[l];
		}

		int p = partition(arr, l, r);
		if (k-1 == p) {
			return arr[p];
		} else if (k > p) {
			return select(arr, p + 1, r, k);
		} else {
			return select(arr, l, p - 1, k);
		}

	}

	private int partition(Comparable<T>[] arr, int l, int r) {
		SortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
		Comparable<T> v = arr[l];

		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (arr[i].compareTo((T) v) > 0) {
				j++;
				SortTestHelper.swap(arr, i, j);
			}
		}
		SortTestHelper.swap(arr, l, j);

		return j;
	}

	public static void main(String[] args) {
		Integer[] randomArr = SortTestHelper.generateRandomArr(10, 0, 30);
		SortTestHelper.printArr(randomArr);
		SelectByQuickSort<Integer> selectByQuickSort = new SelectByQuickSort<>();
		Comparable<Integer> selectNum = selectByQuickSort.select(randomArr,1);
		QuickSortThreeWays<Integer> quickSortThreeWays = new QuickSortThreeWays<>();
		quickSortThreeWays.sort(randomArr);
		SortTestHelper.printArr(randomArr);
		System.out.println(selectNum);
	}

}
