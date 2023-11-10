public class Square {
	private boolean hasShip; // determines this square has a ship
	private String val; // Graphic contained in the square
	private Battleship battleship;
	private boolean played; // indicates the player has played on this square already in TRUE

	public Square(String val) {
		this.val = val;
	}

	public Square() {
	}

	public String toString() { // returns value in that particular square. - , X , B
		return this.val;
	}

	public void putShip(String val, Battleship battleship) { // Assigns a part of the battleship to this square
		this.battleship = battleship;
		this.hasShip = true;
		this.val = val;
	}

	public boolean playedSquare() { // makes sure the square cannot be played again
		return this.played;
	}

	public boolean hasShip() { // returns TRUE if square has a part of ship
		return this.hasShip;
	}

	public int playerGame(String val, Player player) {
		// reduce health of the ship if
		// 1. Square is not already played
		// 2. Battle ship is present in the square
		// 3. Battleship is not sunk
		// System.out.println("status: " + this.battleship.getStatus());
		if (!this.played && this.battleship != null && !this.battleship.getStatus()) {
			this.played = true;
			this.battleship.reduceHealth();
			this.val = " X ";
			if (this.battleship.getHealth() < 1) {
				// if battleship health is 0, player scores. Battleship sinks. Squarevalue is
				// turned to B
				player.increaseScore();
				this.battleship.sinkShip();
				System.out.println(String.format("Battle ship is down! %s gets 1 point", player.getName()));
				return 2; // return 2 to indicate the player has hit and sunk the ship
			}
			System.out.println(String.format("That's a Hit! Good job %s", player.getName()));
			return 1; // reuturn 1 indicating the player has hit the ship
		}
		this.val = val;
		System.out.println("That is a miss!");
		return 0; // return 0 indicating the player missed to hit the ship
	}

}