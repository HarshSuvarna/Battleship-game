public class MediumBattleship extends Battleship {
    // Medium Battleship of size 3 inheriting from battleship
    private static int size = 2;
    private static int smallShipCount = 2;

    public MediumBattleship() {
        super(size);
    }

    public int getSize() {
        return size;
    }

    public static int getMediumShipCount() {
        return smallShipCount;
    }
}
