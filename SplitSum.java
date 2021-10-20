package main;

import java.util.Arrays;

public class SplitSum {
	public static void main(String[] args) {
		int[] myList = new int[10]; 
		
		for(int i = 0; i<myList.length; i++) {
			myList[i] = randomInt(1,100); 
		}
		System.out.println(Arrays.toString(myList));
		System.out.println(Arrays.toString(splitSum(myList))); 
		
		
	}
	
	public static int[] splitSum(int[] list) {
		int[] result = new int[2]; 
		for(int i = 0; i<list.length; i+=2) {
			result[0] += list[i]; 
		}
		for(int i = 1; i<list.length; i+=2) {
			result[1] += list[i]; 
		}
		return result; 
	}
	
	public static int randomInt(int lower, int upper) {
		return (int) ((Math.random() * (upper - lower+1)) + lower);
	}
}
