package main;

public class BinarySort {
	public static void main(String[] args) {
		int[] array = {3,4,6,7,8,9,10,11,12,14,15,66};
		int targetIndex = binarySearch(array, 15);
		
		System.out.println("Found target at index: " + targetIndex);
	}
	
	public static int binarySearch(int[] input, int target) {
		int right = input.length-1; 
		int left = 0; 
		int mid = (left+right)/2;
		
		while(left <= mid && mid <= right) {
			
			if(input[mid] == target) {
				return mid;
			}
			
			drawBinarySearch(left, right, input.length);
			
			if(input[mid] > target) {
				right = mid-1; 
			} else if(input[mid]< target) {
				left = mid+1; 
			}
			mid = (left+right/2);
		}
		return -1;
		
	}
	
	public static void drawBinarySearch(int leftBound, int rightBound, int arrayLength) {
		int indexCounter = 0;
		while(indexCounter<arrayLength) {
			if(indexCounter == leftBound) {
				System.out.print("(");
			} else if(indexCounter == (leftBound+rightBound)/2) {
				System.out.print("|");
			} else if(indexCounter == rightBound) {
				System.out.print(")");
			} else {
				System.out.print("-");
			}
			
			indexCounter++;
		
		}
		System.out.println();
	}
}
