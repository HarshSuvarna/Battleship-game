import java.util.Random;

public class Battleship {
    private boolean sunk;
    private int size;
    private int health;
    private int startRow;
    private int startCol;
    private boolean vertical;
    private int[] occupiedRows = new int[10];
    private int[] occupiesColumns = new int[10];
    private Square[][] board;
    private int[][] shipLocation = new int[3][2];

    public Battleship(Square[][] board) {
        this.board = board;
        Random r = new Random();
        this.vertical = r.nextBoolean();
        this.size = r.nextInt(1, 4);
        this.health = this.size;
        // boolean putShip = false;
        // do {

        this.startRow = r.nextInt(0, 10);
        this.startCol = r.nextInt(0, 10);

        // } while (!putShip);
    }

    public Square[][] generateBattleShip(Battleship battleship) {
        if (this.vertical) {
            for (int i = 0; i < this.size; i++) {
                (this.board[this.startRow + i][this.startCol]).putShip(" * ", battleship);
                // shipLocation[shipLocation.length][0] = this.startRow + i;
                // shipLocation[shipLocation.length][1] = this.startCol;
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                (this.board[this.startRow][this.startCol + i]).putShip(" * ", battleship);
                // shipLocation[shipLocation.length][0] = this.startRow;
                // shipLocation[shipLocation.length][1] = this.startCol + i;
            }
        }
        return this.board;
    }

    public void reduceHealth() {
        this.health -= 1;
    }

    public void sinkShip() {
        this.sunk = true;
    }

    public boolean getStatus() {
        return this.sunk;
    }

    public int getHealth() {
        return this.health;
    }
}
