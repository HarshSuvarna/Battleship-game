import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private static String turn = "Player1";
    private static Scanner scanner = new Scanner(System.in); // static scanner to be shared by all the players

    public Player(String name) {
        this.name = name;
    }

    public String getName() { // returns name of player
        return this.name;
    }

    public static void setTurn(String player) { // set player's turn
        turn = player;
    }

    public static String getTurn() { // return whos turn is it
        return turn;
    }

    public void increaseScore() { // increments the sore by one
        this.score += 1;
    }

    public int getScore() { // return score of player
        return this.score;
    }

    public static int playerTurn(Player player, Square[][] board) {
        try {
            System.out.println(String.format("%s 's turn",
                    player.getName()));
            scanner.nextLine();
            System.out.print("Enter row and column with a space in between: ");
            int row = scanner.nextInt(); // getting row value in input
            int col = scanner.nextInt();// getting column value in input
            System.out.println(row + " " + col);
            if (row < 0 || row > 9 || col < 0 || col > 9) {
                return -1; // return -1 for out of specified bound inputs
            }
            int outCome = board[row][col].playerGame(board[row][col].hasShip() ? " X " : " O ", player);
            return outCome;

        } catch (Exception e) {
            return -1; // return -1 if anything goes wrong.
        }
    }

    public static boolean endgameLogic(Player player1, Player player2, int battleships) {
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();
        if ((player1Score + player2Score) == battleships) { // when cumulative score == number of battleships, the game
                                                            // ends
            if (player1Score == player2Score) { // tie if scores are equal
                System.out.println("Game over. Its a tie!");
            } else {// Making player with highest score win
                System.out.println(String.format("Game over. %s wins!! ",
                        player1Score > player2Score ? player1.getName() : player2.getName()));
            }
            return false; // returing false indicating the game is not over yet
        }
        return true;
    }
}
