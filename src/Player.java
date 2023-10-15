public class Player {
    private String name;
    private int score;
    private static String turn = "Player1";

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTurn(String player) {
        turn = player;
    }

    public String getTurn() {
        return turn;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public int getScore() {
        return this.score;
    }
}
