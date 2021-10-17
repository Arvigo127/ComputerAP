package main;

import java.util.Scanner;

import main.PyList; 

public class AdditionQuiz {
	public static void main(String[] args) {
		String time = String.valueOf(System.currentTimeMillis()); 
				
		int num1 = Integer.valueOf(String.valueOf(time.charAt(9))); 
		int num2 = Integer.valueOf(String.valueOf(time.charAt(10)));
		
		PyList list = new PyList(0);
		
		list.add(3.0);
		list.add(23.0);
		list.add(2.0);
		list.add(1);
		list.add(3.0);
		
		
		
		System.out.println(list.print()); 
		System.out.println(list.max());
		System.out.println(list.min()); 
		System.out.println(list.index(0)); 
		
		list.removeByIndex(4); 
		
		System.out.println(list.print());
		
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
