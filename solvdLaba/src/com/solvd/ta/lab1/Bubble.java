package com.solvd.ta.lab1;

public class Bubble {
    void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    void printArr(int[] nums) {
    	for (int i = 0; i < nums.length; i++) {
    		System.out.print(nums[i] + " ");
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
        int nums[] = {10, 5, 1, 2, 7};
        Bubble bb = new Bubble();
        bb.printArr(nums);
        bb.bubbleSort(nums);
        bb.printArr(nums);
    }
}
