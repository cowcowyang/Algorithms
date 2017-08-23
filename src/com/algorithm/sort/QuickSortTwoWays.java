package com.algorithm.sort;

import com.algorithm.util.SortTestHelper;

/**
 * 双路快速排序： 从数组头尾分别控制两个指针从前至后/从后至前双路移动 
 * 可以平衡分治树，避免因顺序数组或大量重复数据数组造成的快速排序性能退化
 * 
 *  [0,10] , size : 100000
	QuickSort: 826ms
	QuickSortTwoWays: 42ms
	MergeSort: 45ms
 * 
 * @author fyang
 *
 * @param <T>
 */
public class QuickSortTwoWays<T> extends AbstractSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int n = arr.length;
		recursiveSort(arr, 0, n - 1);
	}

	private void recursiveSort(Comparable<T>[] arr, int l, int r) {
		// 数组元素少时采用插入排序提高性能 (递归创建对象GC时间会大幅影响执行效率)
		// if (r - l <= 15) {
		// InsertionSort<T> insertionSort = new InsertionSort<>();
		// insertionSort.sort(arr);
		// return;
		// }
		if (l >= r) {
			return;
		}

		int p = partition(arr, l, r);
		recursiveSort(arr, l, p);
		recursiveSort(arr, p + 1, r);
	}

	private int partition(Comparable<T>[] arr, int l, int r) {
		// 随机交换arr[l]，防止顺序数列使quick sort退化为O(n^2)
		SortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

		Comparable<T> v = arr[l];
		int i = l + 1, j = r;

		while (true) {
			// way 1 : arr[l+1...r]
			while (i <= r && arr[i].compareTo((T) v) < 0) {
				i++;
			}
			// way 2: arr[r...i+1]
			while (j >= i + 1 && arr[j].compareTo((T) v) > 0) {
				j--;
			}
			if (i > j) {
				break;
			}
			SortTestHelper.swap(arr, i, j);
			i++;
			j--;
		}

		SortTestHelper.swap(arr, l, j);

		return j;
	}
}
