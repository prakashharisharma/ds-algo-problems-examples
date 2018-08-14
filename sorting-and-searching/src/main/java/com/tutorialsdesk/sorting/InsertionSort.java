package com.tutorialsdesk.sorting;

import java.util.Arrays;

public class InsertionSort {

	private static void sort(int[] arr) {

		for (int i = 1; i < arr.length; ++i) {
			
			int key = arr[i];
			
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
			
				arr[j + 1] = arr[j];
				j = j - 1;
			
			}
			
			arr[j + 1] = key;
			
		}

	}

	
	public static void main(String[] args) {
		int[] arr = { 5, 1, 9, 3, 8, 7 };

		System.out.println(Arrays.toString(arr));

		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
