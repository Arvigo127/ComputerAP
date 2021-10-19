package main;

import java.util.Scanner;

public class WhilePractice {
	public static void main(String[] args) {
		int evenCounter = 0; 
		int tries = 0; 
		
		Scanner keyboard = new Scanner(System.in);
		
		while(tries<10 && evenCounter<3) {
			System.out.print("Input a number: ");
			int input = keyboard.nextInt();
			if (input%2 ==0) {
				evenCounter++; 
			}
			
			tries++; 
		}
		
		System.out.println(String.format("Exited with %s tries and %s even number",  tries, evenCounter)); 
		
		 
		
		int sum = 0; 
		
		while(sum<=100) {
			System.out.println(String.format("Current sum of : %s",  sum));
			System.out.println("Input a number to add: "); 
			sum += keyboard.nextInt(); 
			 
		}
		
		System.out.println(String.format("Exited with sum of : %s",  sum)); 
		
		keyboard.close();
	}

}
