package main;

import java.util.Hashtable;
import java.util.Scanner;

public class ClothingStateTax {
	public static void main(String[] args) {	
		double amount = 0.0; 
		Scanner keyboard = new Scanner(System.in); 
		Hashtable<String, String> stateTax = new Hashtable<String, String>(); 
		stateTax.put("MA", "1.0" );
		stateTax.put("CT", "1.0635" );
		stateTax.put("ME", "1.05" );
		stateTax.put("VT", "1.06" );
		stateTax.put("RI", "1." );
		stateTax.put("NH", "1.0" );
		
		//receive input and assign unit cost
		System.out.println("how many? "); 
		int input = keyboard.nextInt(); 
		if (0 < input && input <= 9) {
			amount = 15; 
		}
		if (10 <= input && input <= 15) {
			amount = 12.5; 
		}
		if (input > 15) {
			amount = 11.75; 
		}
		
		
		System.out.println("Before Tax: $" + (input * amount)); 
		
		System.out.println("What state");
		String stateinput = keyboard.next(); 
		
		//adds tax 
		double finalAmount = (input*amount) * Double.parseDouble((stateTax.get(stateinput))); 
		
		System.out.println(finalAmount); 
		
		keyboard.close(); 
	}
}
