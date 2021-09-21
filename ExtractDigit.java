package main;

import java.util.Scanner;

public class ExtractDigit {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Number? "); 
		int initial = keyboard.nextInt(); 
		
		int ones_place = initial%10;		
		int tens_place = (initial%100-ones_place)/10;		
		int hundreds_place = initial/100;

		System.out.println(ones_place+tens_place+hundreds_place); 
		
		keyboard.close(); 
		
	}
}
