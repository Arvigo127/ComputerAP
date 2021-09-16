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
		
		System.out.println("Max " + sortMax(myArrary)); 
		System.out.println("Min " + sortMin(myArrary)); 
		
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
	
	public static int sortMax(int[] k_array) {
		int max = 0; 
		for (int i : k_array) {
			if (i > max) {
				max = i; 
			}
		}
		
		return max; 
	}
	
	public static int sortMin(int[] k_array) {
		int max = sortMax(k_array); 
		int min = 0; 
		for (int i: k_array) {
			if (i < max) {
				min = i; 
				max = i; 
			}
		}
		return min; 
	}
	
	public static int randomInt(int lower, int upper) {
		return (int) ((Math.random() * (upper - lower)) + lower);
	}
	
	public static boolean isPrime(int i) {
		double sqrt = Math.sqrt(i);
		boolean prime = true; 
		for (int divisor = 2; divisor <= sqrt; divisor++) {
			if((i%divisor) == 0 ) {
				prime = false;
				break; 
			}
		}

		return prime; 
	}
}


//20 random ints in an array between a range, find max/min/prime