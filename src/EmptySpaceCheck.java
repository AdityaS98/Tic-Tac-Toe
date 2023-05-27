package com.tictactoe;

import java.util.Scanner;

public class EmptySpaceCheck {

	private char[][] board;
	private char currentPlayer;

	public EmptySpaceCheck() {
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

	public boolean isBoardFull() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	public boolean makeMove(int row, int col) {
		if (row < 0 || row >= 3 || col < 0 || col >= 3) {
			System.out.println("Invalid position. Please choose valid row and column values.");
			return false;
		}
		if (board[row][col] != ' ') {
			System.out.println("Position already occupied. Please choose an empty position.");
			return false;
		}

		board[row][col] = currentPlayer;
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
		return true;
	}

	public static void main(String[] args) {
		EmptySpaceCheck game = new EmptySpaceCheck();
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

			if (game.makeMove(row, col)) {
				if (game.isBoardFull()) {
					System.out.println("It's a draw!");
					break;
				}
			}
		}
	}
}
