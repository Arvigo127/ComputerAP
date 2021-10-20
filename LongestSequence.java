package main;


import java.util.Arrays;
import java.util.Scanner;

public class LongestSequence {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		
		//int[] sequence = new int[20]; 
		int[] sequence = {13, 5, 3, 3, 15, 3, 3, 3, 14, 3, 3, 3, 3, 8, 7, 9, 3, 3, 8, 17};
		//for(int i = 0; i<sequence.length; i++) {
		//	sequence[i] = randomInt(0,20); 
		//}
		
		System.out.println(Arrays.toString(sequence)); 
		
		System.out.println("What number to look for?"); 
		int num = keyboard.nextInt(); 
		
		int longest = (int) seqLength(sequence, num); 
		

		System.out.println(String.format("The longest string of %s is %s long.", num, longest)); 
		keyboard.close();
	}
	
	public static double seqLength(int[] c, int num) {

		boolean isin = false;
		int sequence = 0; 
		
		PyList sequences = new PyList(0); 
		
		for(int z:c) {
			if(z==num) {
				isin = true; 
			}
		}
		
		if (!isin) {
			return 0; 
		}
		
		for(int i = 1; i<c.length; i++) {
			
			if(c[i] == c[i-1] && c[i] == num) {
				
				sequence++;
				
			} if(c[i] != num && sequence !=0 && c[i-1] == num) {
				sequences.add(sequence); 
				sequence = 0; 
			}
			
		}
		
		return sequences.max()+1; 
	}
	
	public static int randomInt(int lower, int upper) {
		return (int) ((Math.random() * (upper - lower+1)) + lower);
	}
}
