package com.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Randomization {
	private char[][] board;
	private char playerLetter;
	private char computerLetter;
	private char currentPlayer;

	public Randomization() {
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
		if (letter == 'X' || letter == 'O') {
			playerLetter = letter;
			computerLetter = (playerLetter == 'X') ? 'O' : 'X';
			System.out.println("You chose " + playerLetter + ". The computer will play with " + computerLetter + ".");
		} else {
			System.out.println("Invalid letter. Please choose either 'X' or 'O'.");
		}
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
		currentPlayer = (currentPlayer == playerLetter) ? computerLetter : playerLetter;
		return true;
	}

	public static void main(String[] args) {
		Randomization game = new Randomization();
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.print("Choose a letter (X or O): ");
		char letter = Character.toUpperCase(scanner.next().charAt(0));
		game.chooseLetter(letter);

		int firstPlayer = random.nextInt(2); // 0 for player, 1 for computer

		if (firstPlayer == 0) {
			game.currentPlayer = game.playerLetter;
			System.out.println("Player plays first.");
		} else {
			game.currentPlayer = game.computerLetter;
			System.out.println("Computer plays first.");
		}

		while (true) {
			game.displayBoard();

			if (game.currentPlayer == game.playerLetter) {
				System.out.print("Enter row (0-2): ");
				int row = scanner.nextInt();
				System.out.print("Enter column (0-2): ");
				int col = scanner.nextInt();

				if (game.makeMove(row, col)) {
					if (game.isBoardFull()) {
						System.out.println("It's a draw!");

					}
				}
			}
		}
	}
}
