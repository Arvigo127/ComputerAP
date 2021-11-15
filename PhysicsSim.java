package main;

public class PhysicsSim {
	private char[][] board; 
	
	public PhysicsSim(int boardwidth, int boardheight) {
		board = new char[boardheight][boardwidth]; 
	}
	
	public void initBoard() {
		for(int row = 0; row<board.length; row++) {
			for(int column =0; column<board[0].length; column++) {
				board[row][column] = '-';
			}
		}
	}
	
	public void drawBoard() {
		System.out.println("\n\n\n\n\n\n\n");
		for(int row = 0; row<board.length; row++) {
			for(int column =0; column<board[0].length; column++) {
				System.out.print(board[row][column]);
			}
			System.out.println(); 
		}
		
		
	}
	
	public void addPoint(char c, int x, int y) {
		board[y][x] = c; 
	}
	
	public static void main(String[] args) {
		PhysicsSim ps = new PhysicsSim(8,8);
		
		ps.initBoard();
		ps.drawBoard();
		
		ps.addPoint('h', 3, 3);
		ps.drawBoard();
	}
}
