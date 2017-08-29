package com.algorithm.sort;

import com.algorithm.structure.MaxHeap;
import com.algorithm.util.SortTestHelper;

public class HeapSort<T> extends AbstractSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int n = arr.length;
		MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);
		for (int i = 0 ; i < n; i++) {
			maxHeap.insert(arr[i]);
		}
		for (int i = n - 1; i >= 0; i--) {
			arr[i] = maxHeap.extractMax();
		}
	}
	
	public static void main(String[] args) {
		Integer[] randomArr = SortTestHelper.generateRandomArr(10,0 ,25);
		HeapSort<Integer> heapSort1 = new HeapSort<>();
		heapSort1.sort(randomArr);
	}

}
