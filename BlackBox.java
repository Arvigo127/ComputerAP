package main;

public class BlackBox {
	public static void main(String[] args) {
		char[][] charArray = {{'\0', 'h', 'i', '\0', 't', 'h', 'e', 'r', 'e'}, 
							  {'m', 'y', '\0', 'f', 'r', 'i', 'e', 'n', 'd'}};
			System.out.println(deObfuscate(charArray)); 
			System.out.println("Number of words: " + countWords(charArray));
		}; 
		
	
	
	public static String deObfuscate(char[][] input) {
		String resultString = "";
		for(int y = 0; y < input.length; y++) {
			String currentWord = "";
			for(int x = 0; x<input[y].length; x++) {
				if(input[y][x] > 0x00) {
					currentWord = currentWord.concat(String.valueOf(input[y][x])); 
				} else {
					currentWord = currentWord.concat(" ");
				}
			}
			
			resultString = resultString.concat(currentWord).concat("\n");
		}
		
		return resultString;
	}
	
	public static int countWords(char[][] input) {
		
		int n_words = 0; 
		String currentWord = "";
		
		for(int row = 0; row<input.length; row++) {
			for(int column = 0; column<input[0].length; column++) {
				if(input[row][column] > 0) {
					currentWord = currentWord.concat(String.valueOf(input[row][column]));
					
					if(column == input[0].length-1 || input[row][column+1] == '\0') {
						n_words++;
						currentWord = "";
					}
				}
			}
		}
		
		return n_words; 
	}
}
