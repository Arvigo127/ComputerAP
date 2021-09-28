package main;
import java.util.Scanner;

public class Lottery {
	public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); 
        
        
        int random = (int) (99*Math.random()); 
        System.out.println(random); 
        

        System.out.println("Guess a number 0-99:");
        int guess = keyboard.nextInt();
        
        int random_one = random/10; 
        int random_two = random%10; 
 
        int guess_one = guess%10;
        int guess_two = guess/10; 
 


        if (guess == random) {
            System.out.println("You have won the grand prize: $10,000!"); 
        } else if (random_one == guess_one && random_two==guess_two){
            System.out.println("You have won this prize: $3,000"); 
        } else if (random_one == guess_two ) {
        	System.out.println("You have won this prize: $1000"); 
        } else if (random_two == guess_one && !(random_one==guess_two)) {
        	System.out.println("You have won this prize: $1000"); 
        } else if (random_one == guess_one) { 
        	System.out.println("You have won this prize: $1000"); 
        } else if (random_two == guess_two) {
        	System.out.println("You have won this prize: $1000"); 
        }
        
        else {
        	System.out.println("You failed"); 
        }

        keyboard.close(); 
    }
}
