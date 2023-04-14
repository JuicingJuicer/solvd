package com.solvd.ta.lab1;

import java.util.Random;

class Sort {
	void bubbleSort(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len - i; j++) {
				if (nums[j - 1] > nums[j]) {
					int temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	void selectionSort(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			// current minimum
			int min = i;
			for (int j = i + 1; j < len; j++) {
				if (nums[j] < nums[min]) {
					min = j;
				}
			}
			int temp = nums[min];
			nums[min] = nums[i];
			nums[i] = temp;
		}
	}
}

public class SortComparsion {
	public static void main(String[] args) {
		// array of 50000 random numbers
		Random rando = new Random();
		int nums[] = new int[50000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rando.nextInt(50000);
		}
		int numClone[] = nums.clone();
		int numClone2[] = nums.clone();

		Sort sorter = new Sort();

		long start = System.currentTimeMillis();
		sorter.bubbleSort(numClone);
		long end = System.currentTimeMillis();

		long start2 = System.currentTimeMillis();
		sorter.selectionSort(numClone2);
		long end2 = System.currentTimeMillis();

		System.out.println("Bubble sort time: " + (end - start) + "ms");
		System.out.println("Selection sort time: " + (end2 - start2) + "ms");
	}
}
