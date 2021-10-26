package main;

public class BlackBox {
	public static void main(String[] args) {
		char[][] charArray = {{'\0', 'a', 'd'}, 
							  {'b', 'c', 'f'}};
			System.out.println(deObfuscate(charArray)); 
		}; 
		
	
	
	public static String deObfuscate(char[][] input) {
		String resultString = "";
		for(int y = 0; y < input.length; y++) {
			for(int x = 0; x<input[y].length; x++) {
				if(input[y][x] > 0x00) {
					resultString = resultString.concat(String.valueOf(input[y][x])); 
				}
			}
		}
		
		return resultString;
	}
}
