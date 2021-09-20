package main;

import java.util.Scanner;

public class Change {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Beginning amount? "); 
		Double initial = keyboard.nextDouble(); 
		
		
		int dollars = initial.intValue(); 
		System.out.println(dollars + " dollars."); 
		
		initial = (initial*100) - (dollars*100);
		int change = initial.intValue(); 
		
		System.out.println(change/25 + " Quarters"); 
		change = change%25;
		
		System.out.println(change/10 + " Dimes"); 
		change = change%10;
		
		System.out.println(change/5 + " Nickels"); 
		change = change%5;
		
		System.out.println(change + " Pennies"); 
		
		
		keyboard.close(); 
	}
}
