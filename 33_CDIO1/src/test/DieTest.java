package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Die;

public class DieTest {

	Die d1;

	@Before
	public void setUp() throws Exception 
	{
		d1 = new Die();
	}

	@After
	public void tearDown() throws Exception 
	{
		d1 = null;
	}
	
	// Test ID: UD01.
	// Tester om metoden rollDie giver terningen lige stor sandsynlighed
	// for at slå alle slag.
	@Test
	public void testRollDieFairness() 
	{
		int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, faceValue = 0;
		final int TOTALROLLS = 60000;
		final int FAILRATE = 400; // 400 = 4% af 10000, hvor 10000 er en sjettedel af totalrolls
		final int SJETTEDEL = TOTALROLLS / 6;
		
		for (int i = 0; i <= TOTALROLLS; i++)
		{
			faceValue = d1.rollDie();
			switch (faceValue)
			{
			case (1): one++;   break;
			case (2): two++;   break;
			case (3): three++; break;
			case (4): four++;  break;
			case (5): five++;  break;
			case (6): six++;   break;
			default: fail("Terningen viste én mindre værdi end 1 eller større værdi end 6");
			}
		}
		boolean fairOne   = FAILRATE > Math.abs(SJETTEDEL - one);
		boolean fairTwo   = FAILRATE > Math.abs(SJETTEDEL - two);
		boolean fairThree = FAILRATE > Math.abs(SJETTEDEL - three);
		boolean fairFour  = FAILRATE > Math.abs(SJETTEDEL - four);
		boolean fairFive  = FAILRATE > Math.abs(SJETTEDEL - five);
		boolean fairSix   = FAILRATE > Math.abs(SJETTEDEL - six);
		
		if (!(fairOne && fairTwo && fairThree && fairFour && fairFive && fairSix))
			fail("Terningen var ikke fair.");
		
		
	}
	
	// Test ID: UD02.
	// Tester om metoden rollDie kun viser øjne mellem 1 og 6, begge inklusiv.
	// Altså om det er en 6-sidet terning.
	@Test
	public void testRollDie() 
	{
		int value;
		for(int i = 0; i < 100; i++)
		{
			value = d1.rollDie();
			if(value < 1 || value > 6)
				fail("Terningen viste én mindre værdi end 1 eller større værdi end 6");
		}
	}
	
	// Test ID: UD03.
	// Tester om metoden getValue henter det rigtige antal øjne, som terningen viser.
	@Test
	public void testGetValue() 
	{
	int expected = 4;
	d1.setValue(4);
	int actual = d1.getValue();
	assertEquals(expected, actual);
	}
	
	// Test ID: UD04.
	// Tester om metoden toString laver den rigtig streng repræsentation af Die-objektet.
	@Test
	public void testToString() 
	{
	String expected = "The value of the die is: 4";
	d1.setValue(4);
	String actual = d1.toString();
	assertEquals(expected, actual);
	}

}
