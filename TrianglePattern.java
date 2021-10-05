package main;

import java.util.Scanner;

public class TrianglePattern {
	public static void main(String[] args) {
		int exit = 0;  
		Scanner keyboard = new Scanner(System.in);
		while (exit == 0) {
			System.out.println("Upper limit? "); 
			int upp = keyboard.nextInt(); 
			System.out.println("Pattern? 1/2/3/4"); 
			int patten = keyboard.nextInt();  
			
				if (patten == 1) {	
					for (int i = 1; i<= upp; i++) {
						for (int j = 1; j<=upp; j++) {
							if (j<=i) {
								System.out.print(j);
							} else {
								System.out.print(" "); 
							}
						}
						System.out.println();
					}
				} else if(patten == 2) {
					for (int i = upp; i>= 1; i--) {
						for (int j = 1; j<=i; j++) {
							if (j<=i) {
								System.out.print(j);
							} else {
								System.out.print(" "); 
							}
						}
						System.out.println(); 
					}
				} else if(patten == 3) {	
					for (int i = 1; i<= upp; i++) {
						for (int j = upp; j>=1; j--) {
							if (j<=i) {
								System.out.print(j);
							} else {
								System.out.print(" "); 
							}
						}
						System.out.println();
					}
				} else if(patten == 4) {	
					String space = ""; 
					for (int i = upp; i>= 1; i--) {
						System.out.print(space);
						for (int j = 1; j<=i; j++) {
								System.out.print(j);
							}
						space = space + " "; 
						System.out.println(" "); 
						}
						System.out.println(); 
					
				} else {
					System.out.println("Unrecognized Pattern");
					keyboard.close(); 
					return; 
				}
				System.out.println(); 
			
			 
			System.out.println("Press 1 to exit, 0 to continue:"); 
			exit = (int) keyboard.nextInt();
			
	}
	keyboard.close();
	}
}
