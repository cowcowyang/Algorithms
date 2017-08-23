package com.algorithm.util;

import java.lang.reflect.Method;

public class SortTestHelper {

	private SortTestHelper() {
	};

	public static Integer[] generateRandomArr(int size, int rangeL, int rangeR) {
		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			int x = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
			arr[i] = new Integer(x);
		}
		System.out.println("[" + rangeL + "," + rangeR + "] , size : " + size);
		return arr;
	}

	public static void printArr(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i == arr.length - 1) {
				System.out.println("\n");
			}
		}
	}

	public static void main(String[] args) {
		printArr(generateRandomArr(100, 1, 10));
	}

	public static void swap(Object[] objArr, int i, int j) {
		Object x = objArr[i];
		objArr[i] = objArr[j];
		objArr[j] = x;
	}

	public static <T> boolean isSorted(Comparable<T>[] objArr) {
		for (int i = 0; i < objArr.length - 1; i++) {
			if (objArr[i].compareTo((T) objArr[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	public static <T> void testSoted(String sortClassName, Comparable<T>[] arr) {
		try {
			Class<?> sortClazz = Class.forName(sortClassName);
			Method sortMethod = sortClazz.getMethod("sort", new Class[] { Comparable[].class });

			long startTime = System.currentTimeMillis();
			sortMethod.invoke(sortClazz.newInstance(), new Object[] { arr });
			long endTime = System.currentTimeMillis();

			assert isSorted(arr);

			System.out.println(sortClazz.getSimpleName() + ": " + (endTime - startTime) + "ms");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
