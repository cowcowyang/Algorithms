package com.algorithm.sort;

import com.algorithm.util.SortTestHelper;

public class ShellSort<T> extends AbstractSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {

		int h = 1;
		int n = arr.length;

		while (h < n / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = h; i < n; i++) {
				Comparable<T> e = arr[i];
				int j = i;
				for (; j >= h && e.compareTo((T) arr[j - h]) < 0; j -= h) {
					arr[j] = arr[j - h];
				}
				arr[j] = e;
			}
			h /= 3;
		}

	}

	public static void main(String[] args) {
		Integer[] randomArr = SortTestHelper.generateRandomArr(10, 1, 100);
		ShellSort<Integer> shellSort = new ShellSort<>();
		shellSort.sort(randomArr);
		assert SortTestHelper.isSorted(randomArr);
		SortTestHelper.printArr(randomArr);
	}
}
