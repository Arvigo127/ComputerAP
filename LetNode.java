package main;

public class LetNode {
		private char letter;
		private LetNode nextLet;
		
		public LetNode() {
			letter = '\0';
			nextLet = null; 
			
		}
		
		public LetNode(char c, LetNode l) {
			letter = c; 
			nextLet = l;
		}
		
		public char getLetter() {
			return letter;
		}
		
		public LetNode getNext() {
			return nextLet;
		}
		
		public void setLetter(char l) {
			letter = l; 
		}
		
		public void setNext(LetNode n) {
			nextLet = n; 
		}
}
