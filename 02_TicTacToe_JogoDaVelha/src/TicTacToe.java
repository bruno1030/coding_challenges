import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe{
	
	static String player1Char;
	static String player2Char;
	static String board [][] = new String[3][3];
	static String currentChar;
	static Player firstPlayer;
	static Player currentPlayer;
	static String winner;
	static int blankSpacesQuantity = 9;
	static List<String> availableSpaces = new ArrayList<String>();
	static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		boolean inputIsValid = false;
		
		while(!inputIsValid) {
			System.out.println("Hi Player 1. Do you want X or O?");
			String userInput = scanner.nextLine();
			
			if(!userInput.equalsIgnoreCase("X") && !userInput.equalsIgnoreCase("O")) {
				System.out.println("You should type X or O");
			}else {
				inputIsValid = true;
				player1Char = userInput.toUpperCase();
			}
		}
		
		player2Char = player1Char.equals("X") ? "O" : "X";
		
		System.out.println("player1Char: " + player1Char);
		System.out.println("player2Char: " + player2Char);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {		
				board[i][j] = "";
			}
		}
		
		printBoard();
		
		countBlankSpaces();
		
		while((blankSpacesQuantity > 0) && (!checkWinner())) {
			doNextMove();
			printBoard();
		}
		
		if(winner == null)
			System.out.println("No winners");
		
		System.out.println("Game end");
		
	}

	private static boolean checkWinner() {
		boolean thereIsAWinner = false;
		
		String winnerChar = "";
		
		// check horizontal
		for (int i = 0; i < board.length; i++) {
			if(
					(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]))
					&&
					(!board[i][0].equals("") && !board[i][1].equals("") && !board[i][2].equals(""))
					) {
				winnerChar = board[i][0];
				thereIsAWinner = true;
			}
		}
		
		// check vertical
		for (int i = 0; i < board.length; i++) {
			if(
					(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]))
					&&
					(!board[0][i].equals("") && !board[1][i].equals("") && !board[2][i].equals(""))
					) {
				winnerChar = board[0][i];
				thereIsAWinner = true;
			}
		}
		
		// check diagonal - from top left to bottom right
		if(
				(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
				&&
				(!board[0][0].equals("") && !board[1][1].equals("") && !board[2][2].equals(""))
				) {
			winnerChar = board[0][0];
			thereIsAWinner = true;
		}
		
		// check diagonal - from bottom left to top right
		if(
				(board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2]))
				&&
				(!board[2][0].equals("") && !board[1][1].equals("") && !board[0][2].equals(""))
				) {
			winnerChar = board[2][0];
			thereIsAWinner = true;
		}
		
		if(thereIsAWinner) {
			winner = player1Char.equals(winnerChar) ? "Player 1" : "Player 2";
			System.out.println("The winner is: " + winner);
			return true;
		}
		
		return false;
		
	}

	private static void doNextMove() {
		
		if(firstPlayer == null) {
			setFirstPlayer();
			currentPlayer = firstPlayer;
			System.out.println("Starting the game");
		}
		
		System.out.println("It's " + currentPlayer + " turn");
		
		System.out.println("blankSpacesQuantity: " + String.valueOf(blankSpacesQuantity));
		
		System.out.println("Available spaces: " + availableSpaces);
		
		String nextMove = getUserMove(currentPlayer);
		
		currentPlayer = currentPlayer == Player.PLAYER1 ? Player.PLAYER2 : Player.PLAYER1;
		
		fillBoard(nextMove, currentChar);
		
		countBlankSpaces();
		
		if(currentPlayer == Player.PLAYER1) {
			currentPlayer = Player.PLAYER2;
		}else {
			currentPlayer = Player.PLAYER1;
		}
			
	}

	private static void fillBoard(String nextMove, String currentChar) {
		// example with nextMove = A1:
	    char columnLetter = nextMove.charAt(0); // ex: 'A'
	    char rowNumber = nextMove.charAt(1);    // ex: '1'

	    // example with columnLetter = C:
	    // C - 'A' = 2 -> it means column 2
	    // B - 'A' = 1 -> it means column 1
	    // A - 'A' = 0 -> it means column 0
	    
	    // example with rowNumber = 3:
	    // 3 - '1' = 2 -> it means row 2
	    // 2 - '1' = 1 -> it means row 1
	    // 1 - '1' = 0 -> it means row 0
	    
	    int column = columnLetter - 'A'; // 'A' -> 0, 'B' -> 1, 'C' -> 2
	    int row = rowNumber - '1';       // '1' -> 0, '2' -> 1, '3' -> 2

	    board[row][column] = currentChar;
	}

	private static String getUserMove(Player currentPlayer) {
		
		System.out.println("Type your move");
		
		String move = "";
		
		boolean inputIsValid = false;
		
		while(!inputIsValid) {
			move = scanner.nextLine().toUpperCase();
			System.out.println("Move: " + move);
			
			if(!availableSpaces.contains(move)) {
				System.out.println("Move is invalid");
			}else {
				inputIsValid = true;
			}
		}
		
		return move;
	}

	private static void setFirstPlayer() {
		Random random = new Random();
		
		Player[] players = Player.values();
		
		int randomNumber = random.nextInt(2);
		firstPlayer = players[randomNumber];
	}

	static void printBoard() {
		System.out.println("|   | A | B | C");
		System.out.println("| 1 | " + board[0][0] + "    " + board[0][1] + "    " + board[0][2]);
		System.out.println("| 2 | " + board[1][0] + "    " + board[1][1] + "    " + board[1][2]);
		System.out.println("| 3 | " + board[2][0] + "    " + board[2][1] + "    " + board[2][2]);
	}
	
	private static void countBlankSpaces() {
		availableSpaces.clear();
		blankSpacesQuantity = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {	
				if(board[i][j].equals("")) {
					blankSpacesQuantity ++;
					addBlankSpaceToList(i, j);
				}
			}
		}
	}

	private static void addBlankSpaceToList(int row, int column) {
		// 'A' + 1 means B
		// row 1 column 1 means B2
		String spaceToBeAdded = "" + (char)('A' + column) + (row+1);
		availableSpaces.add(spaceToBeAdded);
	}
	
}

enum Player{
	PLAYER1,
	PLAYER2
}