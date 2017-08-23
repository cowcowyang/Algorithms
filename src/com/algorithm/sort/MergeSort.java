package com.algorithm.sort;

import java.util.Arrays;

import com.algorithm.util.SortTestHelper;

public class MergeSort<T> extends AbstractSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int n = arr.length;
		recursiveSort(arr, 0, n - 1);
	}

	private void recursiveSort(Comparable<T>[] arr, int l, int r) {
		// if (l >= r) {
		// return;
		// }
		// 当数组越小时为有序的状态机率越大，可用InsertionSort提高性能
		if (r - l <= 15) {
			InsertionSort<T> insertionSort = new InsertionSort<>();
			insertionSort.sort(arr, l, r);
			return;
		}

		int mid = (r + l) / 2;
		recursiveSort(arr, l, mid);
		recursiveSort(arr, mid + 1, r);
		if (arr[mid].compareTo((T) arr[mid + 1]) > 0) {
			merge(arr, l, mid, r);
		}
		// System.out.println(String.valueOf(l)+" "+ mid +" "+r);
	}

	// merge arr[l...mid] and arr[mid+1...r]
	public void merge(Comparable<T>[] arr, int l, int mid, int r) {

		Comparable<T>[] copy = Arrays.copyOfRange(arr, l, r + 1);
		// i : left begin j:right begin
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {// 如果左半部分元素已经全部处理完毕
				arr[k] = copy[j - l];
				j++;
			} else if (j > r) { // 如果右半部分元素已经全部处理完毕
				arr[k] = copy[i - l];
				i++;
				// 左半部分所指元素 < 右半部分所指元素
			} else if (copy[i - l].compareTo((T) copy[j - l]) < 0) {
				arr[k] = copy[i - l];
				i++;
			} else { // 左半部分所指元素 >= 右半部分所指元素
				arr[k] = copy[j - l];
				j++;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] randArr = SortTestHelper.generateRandomArr(8, 1, 20);
		SortTestHelper.printArr(randArr);
		MergeSort<Integer> mergeSort = new MergeSort<>();
		mergeSort.sort(randArr);
		SortTestHelper.printArr(randArr);
	}
}
