import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Board board = new Board(10, 10); // creating a new 10X10 board
		Square[][] newBoard = board.generateBoard(); // calling the generateBoard method
		board.createBattleships();
		Scanner s = new Scanner(System.in);
		System.out.print("Enter name of player 1: "); // Input Player 1 name
		String player1Name = s.nextLine();
		Player player1 = new Player(player1Name);
		System.out.print("Enter name of player 2: "); // input Player 2 name
		String player2Name = s.nextLine();
		Player player2 = new Player(player2Name);
		boolean game = true;

		System.out.println("Welcome to Battleship");
		System.out.println(board.toString());
		do { // keep the game running, giving either players turns, till game =TRUE
			String playerTurn = Player.getTurn();

			int outCome = Player.playerTurn(playerTurn.equals("Player1") ? player1 : player2, newBoard);// returns 0 1
																										// or -1:
			if (outCome > 0) {// let player play again if they hit or ship a ship
				Player.setTurn(playerTurn);
			} else if (outCome == 0) {// set other players turn
				Player.setTurn(playerTurn == "Player1" ? "Player2" : "Player1");
			} else {// for anything other than valid input for rows and columns, prompt for a valid
					// input
				System.out.println("Please enter a valid input between 0 and 9");
				Player.setTurn(playerTurn);
			}
			System.out.println(board.toString());

			game = Player.endgameLogic(player1, player2); // returns a boolean

		} while (game);
		s.close();
	}
}
