package com.tictactoe;
/**
 * 
 * @author DELL
 *
 */

public class TiicTacToeBoradUC1 {
	private char[][] board;
	/* 
	 * Declring variable for board
	 */

	public TiicTacToeBoradUC1() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void main(String[] args) {
    	TiicTacToeBoradUC1 board = new TiicTacToeBoradUC1();
        board.displayBoard();
    }
}
