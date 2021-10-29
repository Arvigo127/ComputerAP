package main;

public class BlackBox {
	public static void main(String[] args) {
		char[][] charArray = {{'\0', 'h', 'i', '\0', 't', 'h', 'e', 'r', 'e'}, 
							  {'m', 'y', '\0', 'f', 'r', 'i', 'e', 'n', 'd'}};
			System.out.println(deObfuscate(charArray)); 
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
}
