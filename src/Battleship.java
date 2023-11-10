public class Battleship {
    private boolean sunk; // boolean indicating if the ship has sunk or not
    private int size;
    private int health;

    public Battleship(int size) {
        this.size = size;
        this.health = this.size;

    }

    public int getSize() { // to get size of ship
        return this.size;
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

    public static int getTotalShips() { // get total number of ship
        return SmallBattleship.getSmallShipCount() + MediumBattleship.getMediumShipCount()
                + LargeBattleship.getLargeShipCount();
    }
}
