package main;

import java.util.Scanner;

public class TicTacToe {
	
	static Scanner keyboard = new Scanner(System.in);

	
	public static void main(String[] args) {
		char[][] board = {{'\0','\0','\0',}, {'\0','\0','\0'}, {'\0','\0','\0'}};
		char winner = '\0';
		char[] players = {'X', 'O'};
		int playerIndex = 0; 
		
		while(winner == '\0') {
			
			update(board, players[playerIndex]);
			winner = checkWinner(board);
			drawBoard(board);
			if(playerIndex==0) {
				playerIndex = 1; 
			} else {
				playerIndex = 0;
			}
			
		}
		System.out.println(winner + " won!");
	}
	
	public static void drawBoard(char[][] board) {
		for(int row = 0; row<board.length; row++) {
			System.out.println("-------");
			for(int column = 0; column<board[0].length; column++) {
				String drawToBoard = "|";
				if(board[row][column] > 0) {
					drawToBoard = drawToBoard + board[row][column];
				} else {
					drawToBoard = drawToBoard + " ";
				}
				
				if(column == board[0].length-1) {
					drawToBoard= drawToBoard + "|\n";
				}
				
				System.out.print(drawToBoard);
				
			}
		}
	}
	
	public static void update(char[][] board, char player) {
		
		System.out.println("Enter a row (0,1,2) for player " + player);
		int update_row = keyboard.nextInt();
		
		System.out.println("Enter a column (0,1,2) for player " + player);
		int update_column = keyboard.nextInt();
		
		if(board[update_row][update_column] != 0) {
			System.out.println("Position already taken!");
		
		} else {
			board[update_row][update_column] = player;
		}
		

		
	}
	
	public static char checkWinner(char[][] input) {
		char winner = '\0'; 
		//check vertical

		for(int column = 0; column<input[0].length; column++) {
			if(input[0][column] == input[1][column] && input[1][column] == input[2][column]) {
				return input[0][column];
			}
		}
		
		for(int row = 0; row<input[0].length; row++) {
			if(input[row][0] == input[row][1] && input[row][1] == input[row][2]) {
				return input[row][0];
			}
		}
		
		if (input[0][0] == input[1][1] && input[1][1] == input[2][2]) {
			return input[0][0];
		}
		
		if (input[0][2] == input[1][1] && input[1][1] == input[2][0]) {
			return input[0][0];
		}
		
		
		
		return winner; 

	}
}
