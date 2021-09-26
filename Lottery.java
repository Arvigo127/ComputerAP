package main;
import java.util.Scanner;

public class Lottery {
	public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); 
        System.out.println("Guess a number 0-99:");
        int guess = keyboard.nextInt();
        
        int random = (int) (99*Math.random()); 


        if (guess == random) {
            System.out.println("Correct Guess!"); 
        } else {
            System.out.println(String.format("Wrong, it was %s", random)); 
        }

        keyboard.close(); 
    }
}
