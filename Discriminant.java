package main;

import java.util.Scanner;

public class Discriminant {
	public static void main(String[] args) {

		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("A: ");
		int a = keyboard.nextInt();
		System.out.println("B: ");
		int b= keyboard.nextInt();
		System.out.println("C: ");
		int c= keyboard.nextInt();
		
		int discriminant = (b*b)-4*a*c;
		
		if (discriminant > 0) {
			 System.out.println("2 real solutions"); 
		} else if (discriminant == 0) {
			System.out.println("1 real solution"); 
		} else {
			System.out.println("2 imaginary solutions"); 
		}
		
		

		
		keyboard.close(); 
	}
}
