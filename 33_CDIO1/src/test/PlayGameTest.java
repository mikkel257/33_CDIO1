package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Game;
import game.Player;
import game.TUI;

public class PlayGameTest {
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
	 * Test ID: IG01. Test af de forskellige mullige spil og om spillet er fair.
	 */
	@Test
	public void testPlayTurnWinConditions() {

		// Antal wins hvor 40 point er opnået og der er slået par i en
		// efterfølgende tur.
		int standardWin = 0;
		// Antal wins hvor der slået et par seksere og derefter er slået endnu
		// et par seksere.
		int doubleSixes = 0;
		// Antal gange spiller 1 har vundet.
		int p1Win = 0;
		// Antal gange spiller 2 har vundet.
		int p2Win = 0;

		// Spilleren som har vundet
		Player winner;

		// Har spillerne opnået 40 point?
		boolean player1Reached40;
		boolean player2Reached40;

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

			player1Reached40 = false;
			player2Reached40 = false;

			// Loop for spillet
			while (Game.gameWon == false) {
				// Printer hvis tur det er
				console.printWhosTurn(Game.turn);

				// Spiller turen for den givne spiller.
				if (Game.turn == 0) {
					if (p1.getScore() == 40)
						player1Reached40 = true;
					else
						player1Reached40 = false;

					Game.playTurn(p1, console);
				} else {
					if (p2.getScore() == 40)
						player2Reached40 = true;
					else
						player2Reached40 = false;
					Game.playTurn(p2, console);
				}

				// Sætter hvis tur det er
				Game.turn = (Game.turn + 1) % 2;
			}
			// Sætter turen så den matcher den spiller hvis tur det er.
			Game.turn = (Game.turn + 1) % 2;

			// Sætter vinderen.
			if (Game.turn == 0)
				winner = p1;
			else
				winner = p2;

			// blev der slået et par seksere og derefter endnu et par
			// seksere?
			if (winner.getNewRoll1() == winner.getNewRoll2() && winner.getLastRoll1() == winner.getLastRoll2()
					&& winner.getNewRoll1() == 6 && winner.getLastRoll1() == 6) {
				if (Game.turn == 0)
					p1Win++;
				else
					p2Win++;
				doubleSixes++;
				// Der blev ikke vundet lovligt!!
			}
			// tester om det blev vundet lovligt.
			// Blev der opnået 40 point og slået et par?
			else if (winner.getScore() == 40 && winner.getNewRoll1() == winner.getNewRoll2()) {

				if (Game.turn == 0 && player1Reached40 == true) {
					p1Win++;
					standardWin++;
				} else if (player2Reached40 == true) {
					p2Win++;
					standardWin++;
				} else {
					System.out.println("Failed in 40 points");
					System.out.println("p1: " + Game.gameWon + " " + player1Reached40 + " " + p1.getScore() + " "
							+ p1.getNewRoll1() + " " + p1.getNewRoll2() + " " + p1.getLastRoll1() + " "
							+ p1.getLastRoll2() + " ");
					System.out.println("p2: " + Game.gameWon + " " + player2Reached40 + " " + p2.getScore() + " "
							+ p2.getNewRoll1() + " " + p2.getNewRoll2() + " " + p2.getLastRoll1() + " "
							+ p2.getLastRoll2() + " ");
					fail("Not a valid win");
				}

			}
			else{
				System.out.println("Failed after double sixes");
				System.out.println(
						"p1: " + Game.gameWon + " " + player1Reached40 + " " + p1.getScore() + " " + p1.getNewRoll1()
								+ " " + p1.getNewRoll2() + " " + p1.getLastRoll1() + " " + p1.getLastRoll2() + " ");
				System.out.println(
						"p2: " + Game.gameWon + " " + player2Reached40 + " " + p2.getScore() + " " + p2.getNewRoll1()
								+ " " + p2.getNewRoll2() + " " + p2.getLastRoll1() + " " + p2.getLastRoll2() + " ");
				fail("Not a valid win");
			}
			if (Game.turn == 0)
				console.gameEnd(p1, Game.turn);
			else
				console.gameEnd(p2, Game.turn);
		}
		// print resultat
		System.out.println("Result after " + numberOfTestToRun + " games are: standardWin: " + standardWin
				+ " doubleSixes: " + doubleSixes + " Player 1 wins: " + p1Win + " Player 2 wins: " + p2Win);
	}

}
