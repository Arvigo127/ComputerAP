package main;

import java.util.Scanner;

public class DistanceBetweenPoints {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("X1? "); 
		double x1 = keyboard.nextDouble(); 
		System.out.println("Y1? "); 
		double y1 = keyboard.nextDouble(); 
		System.out.println("X2? "); 
		double x2 = keyboard.nextDouble(); 
		System.out.println("Y2? "); 
		double y2 = keyboard.nextDouble(); 
		
		double final_distance = Math.pow((Math.pow((x2-x1),2)+(Math.pow((y2-y1),2))), 0.5);
		System.out.println(final_distance); 
		
		keyboard.close();
	}
}
