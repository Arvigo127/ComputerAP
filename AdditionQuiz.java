package main;

import java.util.Scanner;

public class AdditionQuiz {
	public static void main(String[] args) {
		String time = String.valueOf(System.currentTimeMillis()); 
				
		int num1 = Integer.valueOf(String.valueOf(time.charAt(9))); 
		int num2 = Integer.valueOf(String.valueOf(time.charAt(10)));
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println(String.format("What is %d + %d",  num1, num2)); 
		int answer = keyboard.nextInt(); 
		
		if (answer == num1+num2) {
			System.out.println(String.format("%d + %d = %d is true", num1, num2, answer)); 
			
		} else {
			System.out.println(String.format("%d + %d = %d is false", num1, num2, answer)); 
		}
		
		keyboard.close(); 
		
	}
	

}
