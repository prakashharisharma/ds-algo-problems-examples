package com.tutorialsdesk.sorting;

import java.util.Arrays;

public class CountingSort {

	private static void sort(int[] arr, int range) {
		// create buckets
		int counter[] = new int[range + 1];
		
		// fill buckets
		for (int i : arr) {
			counter[i]++;
		}
		// sort array
		int index = 0;
		
		for (int i = 0; i < counter.length; i++) {
			
			while (0 < counter[i]) {

				arr[index++] = i;
				
				counter[i]--;
			}
		}

	}

	public static void main(String[] args) {
		
		int[] arr = { 5, 1, 9, 3, 8, 7 };

		System.out.println(Arrays.toString(arr));

		sort(arr, 9);
		System.out.println(Arrays.toString(arr));
	}
}
