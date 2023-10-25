import java.util.Scanner;

public class game {
	public static void main(String[] args) {
		Board board = new Board(10, 10);
		Square[][] newBoard = board.generateBoard();
		int noOfBattleShips = 5;
		for (int i = 0; i < noOfBattleShips; i++) {
			Battleship battleship = new Battleship(newBoard);
			battleship.generateBattleShip(battleship);
		}
		Scanner s = new Scanner(System.in);
		System.out.print("Enter name of player 1: ");
		String player1Name = s.nextLine();
		Player player1 = new Player(player1Name);
		System.out.print("Enter name of player 2: ");
		String player2Name = s.nextLine();
		Player player2 = new Player(player2Name);
		boolean game = true;

		System.out.println("Welcome to Battleship");
		System.out.println(board.toString());
		do {
			String playerTurn = Player.getTurn();

			int outCome = Player.playerTurn(playerTurn.equals("Player1") ? player1 : player2, newBoard);
			if (outCome > 0) {
				Player.setTurn(playerTurn);
			} else if (outCome == 0) {
				Player.setTurn(playerTurn == "Player1" ? "Player2" : "Player1");
			} else {
				System.out.println("Please enter a valid input between 0 and 9");
				Player.setTurn(playerTurn);
			}
			System.out.println(board.toString());

			game = Player.endgameLogic(player1, player2, noOfBattleShips);

		} while (game);
		s.close();
	}
}
