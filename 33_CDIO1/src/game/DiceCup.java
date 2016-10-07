package game;
import game.Die;

public class DiceCup {

	private Die d1;
	private Die d2;

	/**
	 * Opretter et raflebæger med to terninger.
	 */
	public DiceCup()
	{
		d1 = new Die();
		d2 = new Die();
	}
	
	/**
	 * Kaster med terningerne i raflebægret
	 */
	public void rollDice()
	{
		d1.rollDie();
		d2.rollDie();
	}
	
	/**
	 * Henter værdien af terning 1's øjne.
	 * 
	 * @return Returnerer terning 1's værdi.
	 */
	public int getDie1Value() 
	{
		return d1.getValue();
	}
	
	/**
	 * Henter værdien af terning 2's øjne.
	 * 
	 * @return Returnerer terning 2's værdi.
	 */
	public int getDie2Value() 
	{
		return d2.getValue();
	}
	
	/**
	 * Sætter værdien af terning 1.
	 * OBS: Bruges kun til at teste med. Er derfor ikke i diagrammerne.
	 */
	public void setDie1Value(int d1Value)
	{
		d1.setValue(d1Value);
	}
	
	/**
	 * Sætter værdien af terning 2.
	 * OBS: Bruges kun til at teste med. Er derfor ikke i diagrammerne.
	 */
	public void setDie2Value(int d2Value)
	{
		d2.setValue(d2Value);
	}
}
