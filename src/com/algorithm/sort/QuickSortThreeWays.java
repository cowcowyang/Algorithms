package com.algorithm.sort;

import com.algorithm.util.SortTestHelper;

/**
 * 三路快速排序，将数组分为<v 、=v 、>v三部分， 递归排序<v和 >v部分，所以在处理重复率较高的数组时效率显著提升
 * 
 * [0,10] , size : 1000000 QuickSortThreeWays: 69ms QuickSortTwoWays: 182ms
 * MergeSort: 276ms
 * 
 * @author fyang
 *
 * @param <T>
 */
public class QuickSortThreeWays<T> extends AbstractSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int n = arr.length;
		sort(arr, 0, n - 1);
	}

	@Override
	public void sort(Comparable<T>[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		SortTestHelper.swap(arr, l, (int) Math.random() * (r - l + 1) + l);
		Comparable<T> v = arr[l];

		int lt = l; // arr[l...lt] v < 0
		int gt = r + 1; // arr[gt...r] v > 0
		int i = l + 1; // arr[lt + 1 ... i) v == 0

		while (i < gt) {
			if (arr[i].compareTo((T) v) < 0) {
				SortTestHelper.swap(arr, lt + 1, i);
				lt++;
				i++;
			} else if (arr[i].compareTo((T) v) > 0) {
				SortTestHelper.swap(arr, gt - 1, i);
				gt--;
			} else {
				i++;
			}
		}
		SortTestHelper.swap(arr, l, lt);

		sort(arr, l, lt - 1);
		sort(arr, gt, r);

	}

	public static void main(String[] args) {
		Integer[] randomArr = SortTestHelper.generateRandomArr(10, 1, 5);
		SortTestHelper.printArr(randomArr);
		QuickSortThreeWays<Integer> quickSortThreeWays = new QuickSortThreeWays<>();
		quickSortThreeWays.sort(randomArr);
	}
}
