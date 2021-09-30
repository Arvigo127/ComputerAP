package main;

import java.util.Scanner;

public class Gooey {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("hi"); 
		int x = 2;
		int y = 2;
		long sleep_time = 1000; 
		Scanner keyboard = new Scanner(System.in);  
		while (true) {
			String input = keyboard.next(); 
			if (input == "w") {
				y = y++; 
			} else if (input == "a") {
				x = x--; 
			} else if (input == "s") {
				y= y--;
			} else if (input == "d") {
				x =x++; 
			} 
			printScreen(x, y); 
			Thread.sleep(sleep_time);
		}
		 
		
	}
	
	public static void printScreen(int x, int y) {
		System.out.println("\033[H\033[2J");
		for (int i = 0; i<=4; i++) {

			for (int j = 0; j<=4; j++) {
				if (y==i && x==j) {
					System.out.print(0); 
				} else {
				System.out.print("-"); 
				}
			}
			System.out.println(); 
		}
	}
}
