package main;

import java.util.Scanner;

public class ConditionalPractice {
	public static void main(String[] args) {
		int[] list = {0,0,0}; 
		Scanner keyboard = new Scanner(System.in);
		for (int i =0; i<3; i++) {
			System.out.println("Input number"); 
			list[i] = keyboard.nextInt(); 
		}
		
		if (list[0] > list[1] && list[0] > list[2]) {
			System.out.println(list[0] + " is the largest"); 
		}
		
		if (list[1] > list[0] && list[1] > list[2]) {
			System.out.println(list[1] + " is the largest"); 
		}
		
		if (list[2] > list[1] && list[2] > list[0]) {
			System.out.println(list[2] + " is the largest"); 
		}
		
		keyboard.close(); 
		
	}
}


