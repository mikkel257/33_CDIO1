package game;

public class Player {
	private DiceCup diceCup;
	// Spillerens totale point score.
	private int score;
	// Spillerens første terning's øjenværdi, ved nyeste kast.
	private int newRoll1;
	// Spillerens anden terning's øjenværdi, ved nyeste kast.
	private int newRoll2;
	// Spillerens første terning's øjenværdi, ved forrige kast.
	private int lastRoll1;
	// Spillerens anden terning's øjenværdi, ved forrige kast.
	private int lastRoll2;

	/**
	 * Opretter en spiller med et raflebæger.
	 */
	public Player() {
		diceCup = new DiceCup();
		score = 0;
		newRoll1 = 0;
		newRoll2 = 0;
		lastRoll1 = 0;
		lastRoll2 = 0;
	}

	/**
	 * Kaster med to terninger i et raflebæger og tilføjer summen af
	 * terningernes øjenværdier til spillerens score.
	 */
	public void rollDiceCup() {
		diceCup.rollDice();
		lastRoll1 = newRoll1;
		lastRoll2 = newRoll2;
		newRoll1 = diceCup.getDie1Value();
		newRoll2 = diceCup.getDie2Value();
		setScore();
	}

	/**
	 * Sætter spillerens score
	 */
	public void setScore() {
		if (score + newRoll1 + newRoll2 < 40)
			score = score + newRoll1 + newRoll2;
		else
			score = 40;
	}

	/**
	 * Sætter spillerens score til 0
	 */
	public void resetScore() {
		score = 0;
	}

	/**
	 * Henter værdien af spillerens score.
	 * 
	 * @return Returnerer spillerens score.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Henter øjenværdien af spillerens første terning ved forrige kast.
	 * 
	 * @return Returnerer øjenværdien for spillerens første terning ved forrige
	 *         kast.
	 */
	public int getLastRoll1() {
		return lastRoll1;
	}

	/**
	 * Henter øjenværdien af spillerens anden terning ved forrige kast.
	 * 
	 * @return Returnerer øjenværdien for spillerens anden terning ved forrige
	 *         kast.
	 */
	public int getLastRoll2() {
		return lastRoll2;
	}

	/**
	 * Henter øjenværdien af spillerens første terning ved nyeste kast.
	 * 
	 * @return Returnerer øjenværdien for spillerens første terning ved nyeste
	 *         kast.
	 */
	public int getNewRoll1() {
		return newRoll1;
	}

	/**
	 * Henter øjenværdien af spillerens anden terning ved nyeste kast.
	 * 
	 * @return Returnerer øjenværdien for spillerens anden terning ved nyeste
	 *         kast.
	 */
	public int getNewRoll2() {
		return newRoll2;
	}
	
	/**
	 * Sætter værdien af terning nummer 1 ved nyeste kast.
	 * OBS: Bruges kun til at teste med. Er derfor ikke i diagrammerne.
	 */
	public void setNewRoll1(int newRoll1)
	{
		this.newRoll1 = newRoll1;
	}
	
	/**
	 * Sætter værdien af terning nummer 2 ved nyeste kast.
	 * OBS: Bruges kun til at teste med. Er derfor ikke i diagrammerne.
	 */
	public void setNewRoll2(int newRoll2)
	{
		this.newRoll2 = newRoll2;
	}
}
