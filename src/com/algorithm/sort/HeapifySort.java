package com.algorithm.sort;

import com.algorithm.structure.MaxHeap;
import com.algorithm.util.SortTestHelper;

public class HeapifySort<T> extends AbstractSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int n = arr.length;
		// 数组heapify创建
		MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);
		for (int i = n - 1; i >= 0; i--) {
			arr[i] = maxHeap.extractMax();
		}
	}

	public static void main(String[] args) {
		Integer[] randomArr = SortTestHelper.generateRandomArr(10, 0, 25);
		HeapifySort<Integer> heapSort1 = new HeapifySort<>();
		heapSort1.sort(randomArr);
	}
}
