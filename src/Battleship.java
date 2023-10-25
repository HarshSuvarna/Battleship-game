import java.util.Random;

public class Battleship {
    private boolean sunk;
    private int size;
    private int health;
    private int startRow;
    private int startCol;
    private boolean vertical;
    private Square[][] board;
    private static int[] occupiedSquares = new int[10];
    private static int[] occupiesColumns = new int[10];
    private int[][] shipLocation = new int[3][2];
    private boolean placeShipSomewhereElse = true;
    private boolean cantPlaceShip = false;
    private static int ships = 0;

    public Battleship(Square[][] board) {
        this.board = board;
        Random r = new Random();
        this.vertical = r.nextBoolean();
        this.size = r.nextInt(2, 4);
        this.health = this.size;
        this.startRow = r.nextInt(0, 10);
        this.startCol = r.nextInt(0, 10);
    }

    public Square[][] generateBattleShip(Battleship battleship) {
        Random r = new Random();
        while (placeShipSomewhereElse) {
            // System.out.println("while----------------------------------------------");
            for (int i = 0; i < this.size; i++) {
                // System.out.println("i: " + i);
                // System.out.println("row: " + this.startRow);
                // System.out.println("Col: " + this.startCol);
                // System.out.println("vei: " + this.vertical);
                // System.out.println((this.vertical ? this.startRow : this.startCol) + i);
                // if (((this.vertical ? this.startRow : this.startCol) + i > 7)) {
                // System.out.println("in if beacuse row got somehting");
                // cantPlaceShip = true;
                // break;
                // } else
                if (this.board[this.startRow + (this.vertical ? i : 0)][this.startCol
                        + (this.vertical ? 0 : i)]
                        .hasShip()) {
                    cantPlaceShip = true;
                    break;
                }
            }
            if (!cantPlaceShip) {
                placeShipSomewhereElse = false;
                for (int i = 0; i < this.size; i++) {
                    (this.board[this.startRow + (this.vertical ? i : 0)][this.startCol + (this.vertical ? 0 : i)])
                            .putShip(" * ", battleship);

                }
            }
            this.startRow = r.nextInt(0, 10);
            System.out.println("change: " + startCol);
            this.startCol = r.nextInt(0, 10);
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
