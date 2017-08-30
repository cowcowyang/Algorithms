package com.algorithm.sort;

import com.algorithm.util.SortTestHelper;

public class FinalHeapSort<T> extends AbstractSort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int n = arr.length;
		// arr heapify
		for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
			shiftDown2(arr, i, n);
		}

		for (int i = n - 1; i > 0; i--) {
			SortTestHelper.swap(arr, i, 0);
			shiftDown2(arr, 0, i);
		}
	}

	private static void shiftDown(Comparable[] arr, int k, int n) {
		while (2 * k + 1 < n) {
			// left subtree
			int j = 2 * k + 1;
			if (j + 1 < n && arr[j].compareTo(arr[j + 1]) <= 0) {
				j += 1;
			}

			if (arr[k].compareTo(arr[j]) >= 0) {
				break;
			}
			SortTestHelper.swap(arr, k, j);
			k = j;
		}
	}
	
    // 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    private static void shiftDown2(Comparable[] arr, int k, int n){

        Comparable e = arr[k];
        while( 2*k+1 < n ){
            int j = 2*k+1;
            if( j+1 < n && arr[j+1].compareTo(arr[j]) > 0 )
                j += 1;

            if( e.compareTo(arr[j]) >= 0 )
                break;

            arr[k] = arr[j];
            k = j;
        }

        arr[k] = e;
    }

	public static void main(String[] args) {
		Integer[] randomArr = SortTestHelper.generateRandomArr(10, 0, 25);
		SortTestHelper.printArr(randomArr);
		FinalHeapSort<Integer> finalHeapSort = new FinalHeapSort<>();
		finalHeapSort.sort(randomArr);
		SortTestHelper.printArr(randomArr);
	}
}
