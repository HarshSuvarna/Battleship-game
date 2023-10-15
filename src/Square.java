public class Square {
	private boolean hasShip;
	// private BattleShip battleship;
	private String val;
	private Battleship battleship;
	private boolean played;

	public Square(String val) {
		this.val = val;
	}

	public Square() {
	}

	public String toString() {
		return this.val;
	}

	public Square[] addSquareRow() {
		Square[] square = new Square[10];
		return square;
	}

	public void putShip(String val, Battleship battleship) {
		this.battleship = battleship;
		this.hasShip = true;
		this.val = val;
	}

	public boolean playedSquare() {
		return this.played;
	}

	public int playerGame(String val, Player player) {
		if (!this.played && this.battleship != null && !this.battleship.getStatus()) {
			this.played = true;
			this.battleship.reduceHealth();
			if (this.battleship.getHealth() < 1) {
				player.increaseScore();
				this.battleship.sinkShip();
				this.val = " B ";
				System.out.println(String.format("Battle ship is down! %s gets 1 point", player.getName()));
				return 2;
			}
			this.val = " B ";
			System.out.println(String.format("That's a Hit! Good job %s", player.getName()));
			return 1;
		}
		this.val = val;
		System.out.println("That's is a miss!");
		return 0;
	}

	public boolean hasShip() {
		return this.hasShip;
	}
}