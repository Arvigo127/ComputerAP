package main;

import java.util.Arrays;

public class SelectionSort {
	
	public static int findIndexOfMin(int[] items, int start, int end) {
		int minIndex = start; 
		for(int i = start; i<items.length; i++) {
			if(items[i]<items[minIndex]) {
				minIndex = i; 
			}
		}
		return minIndex; 
	}
	
	public static int[] swapIndex(int[] input, int origin, int destination) {
		int temp = input[destination];
		input[destination] = input[origin]; 
		input[origin] = temp; 
		
		return input; 
		
	}
	
	public static int[] sortArray(int[] input) {
		
		int start = 0; 
		
		for(int i = 0; i<input.length; i++) {
			int minIndex = findIndexOfMin(input, start, input.length-1); 
			
			input = swapIndex(input, minIndex, i); 
			
			start = i+1; 
		}
		
		return input; 
	}
	
	public static void main(String[] args) {
		int[] unsorted = {5, 6, 8, 382, 14, -8, 1, -3, 2}; 
		
		int[] sorted = sortArray(unsorted); 
		
		System.out.println(Arrays.toString(sorted)); 
	}
}
