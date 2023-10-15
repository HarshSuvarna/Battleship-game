import java.util.Scanner;

public class game {
	public static void main(String[] args) {
		Board board = new Board(10, 10);
		Square[][] newBoard = board.generateBoard();
		for (int i = 0; i < 2; i++) {
			Battleship battleship = new Battleship(newBoard);
			battleship.generateBattleShip(battleship);
		}
		System.out.println(board.toString());

		Player player1 = new Player("Harsh");
		Player player2 = new Player("Kurved");
		try (Scanner scanner = new Scanner(System.in)) {
			boolean game = true;
			System.out.println("Welcome to Battleship");
			do {
				String playerTurn = player1.getTurn();
				System.out.println(String.format("%s 's turn",
						playerTurn == "Player1" ? player1.getName() : player2.getName()));
				System.out.print("Enter row: ");
				int row = scanner.nextInt();
				System.out.print("Enter column: ");
				int col = scanner.nextInt();
				int outCome = newBoard[row][col].playerGame(" X ", playerTurn == "Player1" ? player1 : player2);
				if (outCome > 0) {
					player2.setTurn(playerTurn);
				} else {
					player2.setTurn(playerTurn == "Player1" ? "Player2" : "Player1");
				}
				System.out.println(board.toString());
				int player1Score = player1.getScore();
				int player2Score = player2.getScore();
				if ((player1Score + player2Score) == 2) {
					game = false;
					if (player1Score == player2Score) {
						System.out.println("Game over. Its a tie!");
					} else {
						System.out.println(String.format("Game over. %s wins!! ",
								player1Score > player2Score ? player1.getName() : player2.getName()));
					}
				}

			} while (game);
		}

	}
}
