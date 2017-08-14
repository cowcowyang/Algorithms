package com.aligorithm.sort;

import com.aligorithm.util.SortTestHelper;

public class SelectSort<T> extends AbstrctSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo((T) arr[i]) < 0) {
					minIdx = j;
				}
				SortTestHelper.swap(arr, i, minIdx);
			}
		}

	}

}
