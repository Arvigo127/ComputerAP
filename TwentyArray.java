package main;


import java.util.Arrays;
import java.util.Scanner;




public class TwentyArray {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int[] myArrary = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}; 
		
		System.out.println("Lower bound? "); 
		int min = keyboard.nextInt(); 
		System.out.println("Upper bound?"); 
		int max = keyboard.nextInt(); 
		
		for (int i = 0; i < 20; i++) {
			myArrary[i] = randomInt(min, max); 
		}
		
		System.out.println(Arrays.toString(myArrary));
		
		System.out.println(String.format("Max %s at index %s", sortMax(myArrary)[0], sortMax(myArrary)[1])); 
		System.out.println(String.format("Min %s at index %s", sortMin(myArrary)[0], sortMin(myArrary)[1])); 
		
		for (int i : myArrary) {
			if (isPrime(i)) {
				System.out.print(i + " is prime ");
			}
			else {
				System.out.print(i + " is not prime ");
			}
		}
		

		
		keyboard.close(); 
		
	}
	
	//O(n)
	public static int[] sortMax(int[] k_array) {
		int[] returns = {0,0}; 
		for (int i=0; i<k_array.length; i++) {
			if (k_array[i] > returns[0]) {
				returns[0] = k_array[i];
				returns[1] = i; 
			}
		}
		
		return returns; 
	}
	
	//O(n)
	public static int[] sortMin(int[] k_array) {
		int max = sortMax(k_array)[0]; 
		int[] returns = {0,0};
		for (int i=0; i<k_array.length; i++) {
			if (k_array[i] < max) {
				returns[0] = k_array[i]; 
				max = k_array[i];
				returns[1] = i; 
			}
		}
		return returns; 
	}
	
	//O(1)
	public static int randomInt(int lower, int upper) {
		return (int) ((Math.random() * (upper - lower+1)) + lower);
	}
	
	//O(n)
	public static boolean isPrime(int i) {
		double sqrt = Math.sqrt(i);
		boolean prime = true; 
		for (int divisor = 2; divisor <= sqrt; divisor++) {
			if((i%divisor) == 0 ) {
				return false;
				 
			}
		}

		return prime; 
	}
}


