package com.algorithm;

import java.util.Arrays;

import com.algorithm.util.SortTestHelper;

public class Test {
	public static void main(String[] args) {
		Integer arrSize = 1000000;
		Integer[] randomArr = SortTestHelper.generateRandomArr(arrSize, 0, 1000000);
		Integer[] randomArr2 = new Integer[arrSize];
		Integer[] randomArr3 = new Integer[arrSize];
		Integer[] randomArr4 = new Integer[arrSize];
		Integer[] randomArr5 = new Integer[arrSize];
		Integer[] randomArr6 = new Integer[arrSize];
		System.arraycopy(randomArr, 0, randomArr2, 0, arrSize);
		System.arraycopy(randomArr, 0, randomArr3, 0, arrSize);
		System.arraycopy(randomArr, 0, randomArr4, 0, arrSize);
		System.arraycopy(randomArr, 0, randomArr5, 0, arrSize);
		System.arraycopy(randomArr, 0, randomArr6, 0, arrSize);
		
		SortTestHelper.testSoted("com.algorithm.sort.QuickSortThreeWays", randomArr);
		SortTestHelper.testSoted("com.algorithm.sort.QuickSortTwoWays", randomArr2);
		SortTestHelper.testSoted("com.algorithm.sort.MergeSort", randomArr3);
		SortTestHelper.testSoted("com.algorithm.sort.HeapSort", randomArr4);
		SortTestHelper.testSoted("com.algorithm.sort.HeapifySort", randomArr5);
		SortTestHelper.testSoted("com.algorithm.sort.FinalHeapSort", randomArr6);
		
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

	public static <T> void mergeSort(Comparable<T>[] arr) {
		int n = arr.length;
		recursiveMerge(arr, 0, n - 1);
	}

	public static <T> void recursiveMerge(Comparable<T>[] arr, int l, int r) {
		if (l >= r) {
			return;
		}

		int mid = (l + r) / 2;
		recursiveMerge(arr, l, mid);
		recursiveMerge(arr, mid + 1, r);
		merge(arr, l, r, mid);
	}

	public static <T> void merge(Comparable<T>[] arr, int l, int r, int mid) {
		Comparable<T>[] temp = Arrays.copyOfRange(arr, l, r + 1);
		SortTestHelper.printArr(temp);
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				arr[k] = temp[j - l];
				j++;
			} else if (j > r) {
				arr[k] = temp[i - l];
				i++;
			} else if (temp[i - l].compareTo((T) temp[j - l]) < 0) {
				arr[k] = temp[i - l];
				i++;
			} else {
				arr[k] = temp[j - l];
				j++;
			}
		}
	}
}