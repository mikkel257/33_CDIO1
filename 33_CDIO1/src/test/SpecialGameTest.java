package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Game;
import game.Player;
import game.TUI;

public class SpecialGameTest {

	Player p1;
	Player p2;
	TUI console;

	@Before
	public void setUp() throws Exception {

		console = new TUI();
	}

	@After
	public void tearDown() throws Exception {

		console = null;
	}

	/**
	 * Test ID: IG02.
	 * Test extrakast og mist alle poin
	 */
	@Test
	public void testExtraTurnLoosePoints() {

		// Antal wins hvor 40 point er opnået og der er slået par i en
		// efterfølgende tur.
		int extraTurns = 0;
		int doubleOnes = 0;

		// Antal test der køres
		int numberOfTestToRun = 10000;

		// For loop der kører spillet numberOfTestToRun antal gange.
		for (int i = 0; i < numberOfTestToRun; i++) {
			// Sætter spil state til false
			Game.gameWon = false;
			// Vælger en tilfældig spiller der starter.
			Game.turn = (int) Math.round(Math.random());
			// Game.turn = 0;

			// Opretter 2 nye spillere, for at undgå gammelt data.
			p1 = new Player();
			p2 = new Player();

			// Loop for spillet
			while (Game.gameWon == false) {
				// Printer hvis tur det er
				console.printWhosTurn(Game.turn);

				// Spiller turen for den givne spiller.
				if (Game.turn == 0) {

					Game.playTurn(p1, console);
					if(p1.getNewRoll1()==p1.getNewRoll2()&&p1.getScore()!=40&&Game.gameWon==false){
						if(p1.getNewRoll1()==1){
							if(p1.getScore()==0){
								doubleOnes++;
							}
							else{
								System.out.println(
										"p1: " + Game.gameWon +  " " + p1.getScore() + " " + p1.getNewRoll1()
												+ " " + p1.getNewRoll2() + " " + p1.getLastRoll1() + " " + p1.getLastRoll2() + " ");
								System.out.println(
										"p2: " + Game.gameWon  + " " + p2.getScore() + " " + p2.getNewRoll1()
												+ " " + p2.getNewRoll2() + " " + p2.getLastRoll1() + " " + p2.getLastRoll2() + " ");
								fail("Player rolled 2 ones and should loose points, but didnt.");
							}
						}
						
						if(Game.turn==1){
							extraTurns++;
						}
						else{
							System.out.println(
									"p1: " + Game.gameWon +  " " + p1.getScore() + " " + p1.getNewRoll1()
											+ " " + p1.getNewRoll2() + " " + p1.getLastRoll1() + " " + p1.getLastRoll2() + " ");
							System.out.println(
									"p2: " + Game.gameWon  + " " + p2.getScore() + " " + p2.getNewRoll1()
											+ " " + p2.getNewRoll2() + " " + p2.getLastRoll1() + " " + p2.getLastRoll2() + " ");
							fail("Player rolled a double, but didnt get an extra turn");
						}
					}
					
				} else {
					Game.playTurn(p2, console);
					if(p2.getNewRoll1()==p2.getNewRoll2()&&p2.getScore()!=40&&Game.gameWon==false){
						if(p2.getNewRoll1()==1){
							if(p2.getScore()==0){
								doubleOnes++;
							}
							else{
								System.out.println(
										"p1: " + Game.gameWon +  " " + p1.getScore() + " " + p1.getNewRoll1()
												+ " " + p1.getNewRoll2() + " " + p1.getLastRoll1() + " " + p1.getLastRoll2() + " ");
								System.out.println(
										"p2: " + Game.gameWon  + " " + p2.getScore() + " " + p2.getNewRoll1()
												+ " " + p2.getNewRoll2() + " " + p2.getLastRoll1() + " " + p2.getLastRoll2() + " ");
								fail("Player rolled 2 ones and should loose points, but didnt.");
							}
						}
						
						if(Game.turn==0){
							extraTurns++;
						}
						else{
							System.out.println(
									"p1: " + Game.gameWon +  " " + p1.getScore() + " " + p1.getNewRoll1()
											+ " " + p1.getNewRoll2() + " " + p1.getLastRoll1() + " " + p1.getLastRoll2() + " ");
							System.out.println(
									"p2: " + Game.gameWon  + " " + p2.getScore() + " " + p2.getNewRoll1()
											+ " " + p2.getNewRoll2() + " " + p2.getLastRoll1() + " " + p2.getLastRoll2() + " ");
							fail("Player rolled a double, but didnt get an extra turn");
						}
					}
				}

				// Sætter hvis tur det er
				Game.turn = (Game.turn + 1) % 2;
				
				
				
			}
			// Sætter turen så den matcher den spiller hvis tur det er.
			Game.turn = (Game.turn + 1) % 2;

		}
		// print resultat
		System.out.println("Number of extra trows: " + extraTurns+" Number double ones below 40 points: "+doubleOnes);
	}

}
