package com.tutorialsdesk.sorting;

import java.util.Arrays;

public class SelectionSort {

	private static void sort(int[] arr) {

		for (int i = 0; i < arr.length-1; i++) {
			
			int min = i;
			
			for (int j = i+1; j < arr.length; j++) {
				
				if (arr[j] < arr[min]) {
					min= j;
				}
			}
			
			// Swap the found minimum element with the first
            // element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
			
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 9, 3, 8, 7 };

		System.out.println(Arrays.toString(arr));

		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
