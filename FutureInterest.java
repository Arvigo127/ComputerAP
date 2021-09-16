package main;

import java.util.Scanner;

public class FutureInterest {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Principal ?"); 
		double principal = keyboard.nextDouble(); 
		
		System.out.println("Yearly interest rate? "); 
		double interest = keyboard.nextDouble(); 
		
		System.out.println("Investment term in years? "); 
		double time = keyboard.nextDouble(); 
		
		double in_paren = (1+ (interest/12)); 
		
		double final_amount = principal*(Math.pow(in_paren, (time*12))); 
		
		System.out.println(final_amount); 
		
		keyboard.close();
	}
}
