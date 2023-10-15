public class Board {
    private int rows;
    private int columns;
    private Square[][] board = new Square[10][10];

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public Square[][] generateBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                board[i][j] = new Square(" - ");
            }
        }
        return board;
    }

    public String toString() {
        String newBoard = "";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                newBoard += board[i][j];
            }
            newBoard += "\n";
        }
        return newBoard;
    }
}