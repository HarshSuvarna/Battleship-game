import java.util.Random;

public class Board {
    private int rows;
    private int columns;
    private Square[][] board = new Square[10][10];
    private int startRow;
    private int startCol;
    private boolean vertical;
    private boolean placeShipSomewhereElse = true;
    private boolean cantPlaceShip = false; // becomes TRUE when there is an overlap
    private boolean outofBounds = false; // becomes TRUE when the co-ordinates goes out of bounds

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public Square[][] generateBoard() {// create a 2D matrix of type Square of specified dimensions
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                board[i][j] = new Square(" - ");
            }
        }
        return board;
    }

    public String toString() {// reloading toString method to display the board
        String newBoard = "";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                newBoard += board[i][j];
            }
            newBoard += "\n";
        }
        return newBoard;
    }

    public void createBattleships() {
        for (int i = 0; i < SmallBattleship.getSmallShipCount(); i++) { // Generating small battleships
            SmallBattleship smallBattleships = new SmallBattleship();
            generateBattleShip(smallBattleships);
        }
        for (int i = 0; i < MediumBattleship.getMediumShipCount(); i++) { // Generating medium battleships
            // baord
            MediumBattleship mediumBattleship = new MediumBattleship();
            generateBattleShip(mediumBattleship);
        }
        for (int i = 0; i < LargeBattleship.getLargeShipCount(); i++) { // Generating large battleships
            LargeBattleship largeBattleships = new LargeBattleship();
            generateBattleShip(largeBattleships);
        }

    }

    public void generateBattleShip(Battleship battleship) {
        Random r = new Random();
        this.vertical = r.nextBoolean(); // randomizing alignment of ship
        this.startRow = r.nextInt(0, 10); // random startrow of ship
        this.startCol = r.nextInt(0, 10);// random start column of ship

        // Place ship somewhere else generating new start row and column when:
        // 1. Start row or column are out of bounds
        // 2. The ship is overlapping another ship
        // 3. The square already has a ship
        int size = battleship.getSize();
        placeShipSomewhereElse = true;
        while (placeShipSomewhereElse) {
            outofBounds = false;
            cantPlaceShip = false;
            if (this.startRow + size > 9 || this.startCol + size > 9) // checking for out of bound columns
                outofBounds = true;

            if (!outofBounds) {
                // if start column and rows are not out of bounds check if the squares do not
                // have other ships
                for (int i = 0; i < size; i++) {
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
                for (int i = 0; i < size; i++) { // placing the ship
                    (this.board[this.startRow + (this.vertical ? i : 0)][this.startCol + (this.vertical ? 0 : i)])
                            .putShip(" * ", battleship);

                }
            }
            // generating new start rows and columns
            this.startRow = r.nextInt(0, 10);
            this.startCol = r.nextInt(0, 10);
        }
    }
}
