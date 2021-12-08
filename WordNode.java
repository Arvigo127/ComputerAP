package main;

public class WordNode {
	private LetNode firstLet;
	private WordNode nextWord; 
	
	public WordNode() {
		firstLet = new LetNode(); 
		nextWord = null; 
	}
	
	public WordNode(LetNode l, WordNode w) {
		firstLet = l; 
		nextWord = w; 
	}
	
	public WordNode(char[] c) {
		firstLet = new LetNode(c[0], null); 
		
		LetNode snaker = firstLet; 
		
		for(int i = 1; i<c.length; i++) {
			snaker.setNext(new LetNode(c[i], null));
			snaker = snaker.getNext();
		}
	}
	
	public String getLetNodes() {
		String result = ""; 
		LetNode snaker = firstLet; 
		
		result = result + String.valueOf(snaker.getLetter());
		
		while(snaker.getNext() != null) {
			snaker = snaker.getNext();
			result = result + String.valueOf(snaker.getLetter());
		}
			
		return result; 
	}
	

		
	
	public LetNode getFirstLet() {
		return firstLet;
	}
	
	public WordNode getNextWord() {
		return nextWord; 
	}
	
	public void setFirstLet(LetNode l) {
		firstLet = l; 
	}
	
	public void setNextWord(WordNode w) {
		nextWord = w; 
	}
}
