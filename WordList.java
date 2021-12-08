package main;

public class WordList {
	private WordNode head; 
	
	public WordList() {
		head = new WordNode(); 
	}
	
	public WordList(WordNode w) {
		head = w; 
	}	
	
	public WordList(String input) {
		head = new WordNode(); 
		
		if(input.length() == 0) {
			return;
		}
		
		String[] split_input = input.split(" "); 
		WordNode snaker = head;
		
		for(String s: split_input) {
			snaker.setNextWord(new WordNode(s.toCharArray()));
			snaker = snaker.getNextWord(); 
		}
	}
	
	public void print() {
		WordNode snaker = head;
		System.out.print(snaker.getLetNodes() + " ");
		
		while(snaker.getNextWord() != null) {
			snaker = snaker.getNextWord();
			System.out.print(snaker.getLetNodes() + " ");
		}
		
		System.out.println(""); 
	}
	
	public void append(WordNode w) {
		WordNode snaker = head; 
		
		while(snaker.getNextWord() != null) {
			snaker = snaker.getNextWord();
		}
		
		snaker.setNextWord(w);
	}
	

	
	public static void main(String[] args) {
		WordList wl = new WordList("Hey there buddy how are you doing today"); 
		wl.print(); 
	}
}
