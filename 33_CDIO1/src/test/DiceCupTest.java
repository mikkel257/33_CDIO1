package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.DiceCup;

public class DiceCupTest {
	DiceCup dc;	

	@Before
	public void setUp() throws Exception {
		dc = new DiceCup();
	}

	@After
	public void tearDown() throws Exception {
		dc = null;
	}
	
	// Test ID: IDC01.
	// Tester om metoden rollDice kaster med to terninger, som hver har en værdi mellem 1 og 6.
	@Test
	public void testRollDice() {		
		for(int i = 0; i < 100; i++)
		{
			dc.rollDice();			
			if((dc.getDie1Value() < 1 || dc.getDie1Value() > 6) && (dc.getDie2Value() < 1 || dc.getDie2Value() > 6))
				fail("En af terningerne viste en ugyldig værdi");
		}		
	}
	
	// Test ID: IDC02.
	// Tester om metoden getDie1Value henter det rigtige antal øjne for terning 1.
	@Test
	public void testGetDie1Value() {
		dc.setDie1Value(5);
		int expected = 5;
		int actual = dc.getDie1Value();
		assertEquals(actual, expected);
	}
	
	// Test ID: IDC03.
	// Tester om metoden getDie2Value henter det rigtige antal øjne for terning 2.
	@Test
	public void testGetDie2Value() {
		dc.setDie2Value(3);
		int expected = 3;
		int actual = dc.getDie2Value();
		assertEquals(actual, expected);
	}
}
