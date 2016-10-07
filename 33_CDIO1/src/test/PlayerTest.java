package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Player;

public class PlayerTest {
	
	Player p1;

	@Before
	public void setUp() throws Exception {
		p1 = new Player();
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
	}
	
	// Test ID: IP01.
	// Tester om metoden rollDiceCup sætter de forskellige terning værdier korrekt.
	@Test
	public void testRollDiceCup() {	
		p1.rollDiceCup();
		int expectedLastRoll1 = p1.getNewRoll1();
		int expectedLastRoll2 = p1.getNewRoll2();
		p1.rollDiceCup();
		int actualLastRoll1 = p1.getLastRoll1();
		int actualLastRoll2 = p1.getLastRoll2();
		if(expectedLastRoll1 != actualLastRoll1 && expectedLastRoll2 != actualLastRoll2)
			fail("Terning værdierne for sidste kast passer ikke");
		p1.setNewRoll1(2);
		p1.setNewRoll2(4);
		int expectedNewRoll1 = 2;
		int expectedNewRoll2 = 4;
		int actualNewRoll1 = p1.getNewRoll1();
		int actualNewRoll2 = p1.getNewRoll2();
		assertEquals(expectedNewRoll1, actualNewRoll1);
		assertEquals(expectedNewRoll2, actualNewRoll2);
	}
	
	// Test ID: IP02.
	// Tester om metoden setScore sætter spillerens score korrekt.
	@Test
	public void testSetScore() {
		p1.setNewRoll1(4);
		p1.setNewRoll2(2);
		p1.setScore();
		int actual = p1.getScore();
		int expected = 6;
		assertEquals(actual, expected);
	}
	
	// Test ID: IP03.
	// Tester om metoden setScore kan sætte spillerens score til mere end 40 point.
	@Test
	public void testSetScoreAbove40() {
		for(int i = 0; i < 31; i++)
		{
			p1.rollDiceCup();			
		}
		if(p1.getScore() > 40)
			fail("Spillerens score er over 40 point");
	}
	
	// Test ID: IP04.
	// Tester om metoden resetScore sætter spillerens point til 0.
	@Test
	public void testResetScore() {
		for(int i = 0; i < 6; i++)
		{
			p1.rollDiceCup();			
		}
		
		p1.resetScore();
		int expected = 0;
		int actual = p1.getScore();
		assertEquals(actual, expected);
	}
	
	// Test ID: IP05.
	// Tester om metoden getScore henter spillerens score.
	@Test
	public void testGetScore() {
		p1.setNewRoll1(2);
		p1.setNewRoll2(2);
		p1.setScore();
		int expected = 4;
		int actual = p1.getScore();
		assertEquals(actual, expected);
	}
	
	// Test ID: IP06.
	// Tester om metoden getLastRoll1 henter terning 1's øjenværdi, ved forrige kast.
	@Test
	public void testGetLastRoll1() {
		p1.rollDiceCup();
		int expected = p1.getNewRoll1();
		p1.rollDiceCup();
		int actual = p1.getLastRoll1();		
		assertEquals(actual, expected);
	}
	
	// Test ID: IP07.
	// Tester om metoden getLastRoll2 henter terning 2's øjenværdi, ved forrige kast.
	@Test
	public void testGetLastRoll2() {
		p1.rollDiceCup();
		int expected = p1.getNewRoll2();
		p1.rollDiceCup();
		int actual = p1.getLastRoll2();		
		assertEquals(actual, expected);
	}
	
	// Test ID: IP08.
	// Tester om metoden getNewRoll1 henter den rigtige øjenværdi for terning 1, ved nyeste kast.
	@Test
	public void testGetNewRoll1() {
		p1.setNewRoll1(3);
		int expected = 3;
		int actual = p1.getNewRoll1();
		assertEquals(actual, expected);
	}
	
	// Test ID: IP09.
	// Tester om metoden getNewRoll2 henter den rigtige øjenværdi for terning 2, ved nyeste kast.
	@Test
	public void testGetNewRoll2() {
		p1.setNewRoll2(1);
		int expected = 1;
		int actual = p1.getNewRoll2();
		assertEquals(actual, expected);
	}

}
