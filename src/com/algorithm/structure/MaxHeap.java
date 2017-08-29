package com.algorithm.structure;

import com.algorithm.util.PrintableMaxHeap;
import com.algorithm.util.SortTestHelper;

public class MaxHeap<T extends Comparable> {
	private int capacity;
	protected int count;
	protected T[] data;

	public MaxHeap(int capacity) {
		this.capacity = capacity;
		data = (T[]) new Comparable[capacity + 1];
		count = 0;
	}

	public MaxHeap(T[] arr) {
		int n = arr.length;
		data = (T[]) new Comparable[n + 1];
		capacity = n;
		
		for (int i = 0; i < n; i++) {
			data[i + 1] = arr[i];
		}
		count = n;

		// array heapify
		for(int  i = count/2 ; i >= 1; i--){
			shiftDown(i);
		}
	}

	public int size() {
		return capacity;
	}

	public boolean isEmpty() {
		return data.length == 0;
	}

	public void insert(T item) {
		assert count + 1 <= capacity;
		data[count + 1] = item;
		count++;
		shiftUp(count);
	}

	public T extractMax() {
		assert count > 0;
		T t = data[1];
		SortTestHelper.swap(data, 1, count);
		count--;
		shiftDown(1);

		return t;
	}

	private void shiftDown(int k) {
		while (2 * k <= count) {
			int j = 2 * k; // left child
			if (j + 1 <= count && data[j].compareTo(data[j + 1]) < 0) {
				j++; // right child
			}
			if(data[k].compareTo(data[j])  >= 0){
				break;
			}
			SortTestHelper.swap(data, k, j);
			k = j;
		}
	}

	private void shiftUp(int k) {
		while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
			SortTestHelper.swap(data, k, k / 2);
			k /= 2;
		}
	}

	public static void main(String[] args) {
		PrintableMaxHeap maxHeap = new PrintableMaxHeap(50);
		int N = 50; // 元素个数
		int M = 100; // 取值范围 [0,M)
		for (int i = 0; i < N; i++) {
			maxHeap.insert(new Integer((int) (Math.random() * M)));
		}
		// maxHeap.treePrint();
		for (int i = 0; i < N; i++) {
			System.out.println(maxHeap.extractMax());
		}

	}
}
