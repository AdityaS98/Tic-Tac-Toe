package com.tictactoe;

import java.util.Scanner;

public class ValidCell {

	private char[][] board;
	private char currentPlayer;

	public ValidCell() {
		board = new char[3][3];
		currentPlayer = ' ';
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

	public void chooseLetter(char letter) {
		currentPlayer = letter;
	}

	public void makeMove(int row, int col) {
		if (row < 0 || row >= 3 || col < 0 || col >= 3) {
			System.out.println("Invalid position. Please choose valid row and column values.");
			return;
		}
		if (board[row][col] != ' ') {
			System.out.println("Position already occupied. Please choose an empty position.");
			return;
		}

		board[row][col] = currentPlayer;
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	}
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		ValidCell game = new ValidCell();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Choose a letter (X or O): ");
		char letter = Character.toUpperCase(scanner.next().charAt(0));
		game.chooseLetter(letter);

		while (true) {
			game.displayBoard();
			System.out.print("Enter row (0-2): ");
			int row = scanner.nextInt();
			System.out.print("Enter column (0-2): ");
			int col = scanner.nextInt();

			game.makeMove(row, col);
		}
	}
}
