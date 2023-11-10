public class LargeBattleship extends Battleship {
    // largeBattleship of size 3 inheriting from battleship
    private static int size = 3;
    private static int smallShipCount = 1;

    public LargeBattleship() {
        super(size); // importing all functions from parent class
    }

    public int getSize() {
        return size;
    }

    public static int getLargeShipCount() {
        return smallShipCount;
    }
}
