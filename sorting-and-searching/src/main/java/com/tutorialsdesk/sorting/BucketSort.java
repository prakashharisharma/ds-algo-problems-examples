package com.tutorialsdesk.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {

	private static final int DEFAULT_BUCKET_SIZE = 5;

	public static void sort(Integer[] array) {
		sort(array, DEFAULT_BUCKET_SIZE);
	}

	public static void sort(Integer[] array, int bucketSize) {
		if (array.length == 0) {
			return;
		}

		// Determine minimum and maximum values
		Integer minValue = array[0];
		Integer maxValue = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
			} else if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}

		// Initialise buckets
		int bucketCount = (maxValue - minValue) / bucketSize + 1;
		List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
		for (int i = 0; i < bucketCount; i++) {
			buckets.add(new ArrayList<Integer>());
		}

		// Distribute input array values into buckets
		for (int i = 0; i < array.length; i++) {
			buckets.get((array[i] - minValue) / bucketSize).add(array[i]);
		}

		// Sort buckets and place back into input array
		int currentIndex = 0;
		for (int i = 0; i < buckets.size(); i++) {
			Integer[] bucketArray = new Integer[buckets.get(i).size()];
			bucketArray = buckets.get(i).toArray(bucketArray);
			InsertionSort.sort(bucketArray);
			for (int j = 0; j < bucketArray.length; j++) {
				array[currentIndex++] = bucketArray[j];
			}
		}
	}

	public static void main(String[] args) {
		
		Integer[] arr = { 5, 1, 9, 3, 8, 7 };

		System.out.println(Arrays.toString(arr));

		sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	//Private class
	private static class InsertionSort{
		
		public static void sort(Integer[] arr) {

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
	}
}
