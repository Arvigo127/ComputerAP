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
        System.out.println(random_one); 
        int random_two = random%10; 
        System.out.println(random_two); 
        
        int guess_one = guess%10;
        int guess_two = guess/10; 
        System.out.println(guess_two); 
        System.out.println(guess_one); 


        if (guess == random) {
            System.out.println("Correct Guess!"); 
        } else if (random_one == guess_one && random_two==guess_two){
            System.out.println(String.format("The digits were right, but in the wrong order! %s", random)); 
        } else if (random_one == guess_two ) {
        	System.out.println(String.format("You got one digit right, the correct was %s", random)); 
        } else if (random_two == guess_one && !(random_one==guess_two)) {
        	System.out.println(String.format("You got one digit right, the correct was %s", random)); 
        } else {
        	System.out.println("You failed"); 
        }

        keyboard.close(); 
    }
}
