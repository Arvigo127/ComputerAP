package main;

import java.util.Scanner;

public class LongestSequence {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What number to look for?"); 
		int num = keyboard.nextInt(); 
		
		int[] sequence = new int[20]; 
		
		for(int i = 0; i<sequence.length; i++) {
			sequence[i] = randomInt(0,20); 
		}
		
		int longest = seqLength(sequence, num); 
		
		System.out.println(longest); 
		keyboard.close();
	}
	
	public static int seqLength(int[] c, int num) {
		int sequence = 0;
		int last = c[0];
		
		for(int i = 1; i<c.length; i++) {
			if(c[i] == last) {
				sequence++;
			}
			last = c[i];
		}
		
		return sequence; 
	}
	
	public static int randomInt(int lower, int upper) {
		return (int) ((Math.random() * (upper - lower+1)) + lower);
	}
}
