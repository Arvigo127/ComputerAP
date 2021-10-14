package main;

import java.util.Arrays;

public class WordArray {
	public static void main(String[] args) {
		int[] word = new int[25];
		for (int i = 0; i < word.length; i++) {
			word[i] = randomInt(65, 90); 
		}
		
		System.out.println(Arrays.toString(word));
		
		char[] chars = new char[25];
		
		for (int i = 0; i<chars.length; i++) {
			chars[i] = (char) word[i]; 
		}

		System.out.println(Arrays.toString(chars));
		System.out.println(Arrays.toString(word));
		
		
		
	}
	
	public static int randomInt(int lower, int upper) {
		return (int) ((Math.random() * (upper - lower+1)) + lower);
	}
}
