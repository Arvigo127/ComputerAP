package main;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		int[] myList = new int[10];
		
		for(int i = 0; i<myList.length; i++) {
			myList[i] = randomInt(0,10); 
		}
		
		System.out.println(Arrays.toString(myList));
		System.out.println(Arrays.toString(reverseArray(myList))); 
		
		
	}
	
	public static int randomInt(int lower, int upper) {
		return (int) ((Math.random() * (upper - lower+1)) + lower);
	}
	
	public static int[] reverseArray(int[] input) {
		int[] result = new int[input.length]; 
		int tmpAssignPointer = 0; 
		
		for(int i = input.length-1; i>=0; i--) {
			result[tmpAssignPointer] = input[i]; 
			tmpAssignPointer++; 
			
			
		}
		
		return result; 
	}
}
