import java.util.Random;

public class Battleship {
    private boolean sunk; // boolean indicating if the ship has sunk or not
    private int size;
    private int health;
    private int startRow;
    private int startCol;
    private boolean vertical;
    private Square[][] board;
    private boolean placeShipSomewhereElse = true;
    private boolean cantPlaceShip = false; // becomes TRUE when there is an overlap
    private boolean outofBounds = false; // becomes TRUE when the co-ordinates goes out of bounds

    public Battleship(Square[][] board) {
        this.board = board;
        Random r = new Random();
        // random boolean assignment determining alignment.
        // TRUE: Vertical
        // FALSE: Horizontal
        this.vertical = r.nextBoolean();
        this.size = r.nextInt(2, 4); // random int for size and health of ship
        this.health = this.size;
        this.startRow = r.nextInt(0, 10); // random startrow of ship
        this.startCol = r.nextInt(0, 10);// random start column of ship
    }

    public Square[][] generateBattleShip(Battleship battleship) {
        Random r = new Random();
        // Place ship somewhere else generating new start row and column when:
        // 1. Start row or column are out of bounds
        // 2. The ship is overlapping another ship
        // 3. The square already has a ship
        while (placeShipSomewhereElse) {
            outofBounds = false;
            cantPlaceShip = false;
            if (this.startRow + this.size > 9 || this.startCol + this.size > 9) // checking for out of bound columns
                outofBounds = true;

            if (!outofBounds) {
                // if start column and rows are not out of bounds check if the squares do not
                // have other ships
                for (int i = 0; i < this.size; i++) {
                    if (this.board[this.startRow + (this.vertical ? i : 0)][this.startCol
                            + (this.vertical ? 0 : i)]
                            .hasShip()) {
                        cantPlaceShip = true;
                        break; // if overlap, then break out of loop
                    }
                }
            }
            // if there are no rows and column boundary issues and no overlaps, place the
            // ship according to its alignment
            if (!cantPlaceShip && !outofBounds) {
                placeShipSomewhereElse = false;
                for (int i = 0; i < this.size; i++) { // placing the ship
                    (this.board[this.startRow + (this.vertical ? i : 0)][this.startCol + (this.vertical ? 0 : i)])
                            .putShip(" * ", battleship);

                }
            }
            // generating new start rows and columns
            this.startRow = r.nextInt(0, 10);
            this.startCol = r.nextInt(0, 10);
        }
        return this.board;
    }

    public void reduceHealth() { // to reduce health of battleship
        this.health -= 1;
    }

    public void sinkShip() { // to sink the ship
        this.sunk = true;
    }

    public boolean getStatus() { // return status of battleship(has Sunk or not)
        return this.sunk;
    }

    public int getHealth() { // returns health of battleship
        return this.health;
    }
}
