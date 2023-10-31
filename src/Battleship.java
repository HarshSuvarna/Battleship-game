import java.util.Random;

public class Battleship {
    private boolean sunk;
    private int size;
    private int health;
    private int startRow;
    private int startCol;
    private boolean vertical;
    private Square[][] board;
    private boolean placeShipSomewhereElse = true;
    private boolean cantPlaceShip = false;
    private boolean outofBounds = false;

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
            outofBounds = false;
            cantPlaceShip = false;
            if (this.startRow + this.size > 9 || this.startCol + this.size > 9) {
                this.startRow = r.nextInt(0, 10);
                this.startCol = r.nextInt(0, 10);
                outofBounds = true;
            }
            if (!outofBounds) {
                for (int i = 0; i < this.size; i++) {
                    if (this.board[this.startRow + (this.vertical ? i : 0)][this.startCol
                            + (this.vertical ? 0 : i)]
                            .hasShip()) {
                        cantPlaceShip = true;
                        break;
                    }
                }
            }
            if (!cantPlaceShip && !outofBounds) {
                placeShipSomewhereElse = false;
                for (int i = 0; i < this.size; i++) {
                    (this.board[this.startRow + (this.vertical ? i : 0)][this.startCol + (this.vertical ? 0 : i)])
                            .putShip(" - ", battleship);

                }
            }
            this.startRow = r.nextInt(0, 10);
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
