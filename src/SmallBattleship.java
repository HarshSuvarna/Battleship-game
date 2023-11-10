public class SmallBattleship extends Battleship {
    // Medium Battleship of size 3 inheriting from battleship
    private static int size = 1;
    private static int smallShipCount = 3;

    public SmallBattleship() {
        super(size);
    }

    public int getSize() {
        return size;
    }

    public static int getSmallShipCount() {
        return smallShipCount;
    }
}
