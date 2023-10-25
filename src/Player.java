import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private static String turn = "Player1";
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static void setTurn(String player) {
        turn = player;
    }

    public static String getTurn() {
        return turn;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public int getScore() {
        return this.score;
    }

    public static int playerTurn(Player player, Square[][] board) {
        try {
            System.out.println(String.format("%s 's turn",
                    player.getName()));
            scanner.nextLine();
            System.out.print("Enter row: ");
            int row = scanner.nextInt();
            System.out.print("Enter column: ");
            int col = scanner.nextInt();
            if (row < 0 || row > 9 || col < 0 || col > 9) {
                return -1;
            }
            int outCome = board[row][col].playerGame(" X ", player);
            return outCome;

        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean endgameLogic(Player player1, Player player2) {
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();
        if ((player1Score + player2Score) == 5) {
            if (player1Score == player2Score) {
                System.out.println("Game over. Its a tie!");
            } else {
                System.out.println(String.format("Game over. %s wins!! ",
                        player1Score > player2Score ? player1.getName() : player2.getName()));
            }
            return false;
        }
        return true;
    }
}
