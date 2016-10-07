package game;

public class Game {
	// turn = 0 for spiller 1 og turn = 1 for spiller 2.
	public static int turn = 0;
	public static boolean gameWon = false;

	public static void main(String[] args) {

		// Opretter de objekter og variable der bruges i programmet.
		Player p1 = new Player();
		Player p2 = new Player();
		TUI console = new TUI();
		String consoleInput = "unassigned";
		// turn = 0;
		// Vælger en tilfældig spiller til start.
		turn = (int) Math.round(Math.random());

		// Henter konsol introen.
		console.intro();

		// Løkken kører så længe spillet ikke er vundet.
		while (!gameWon) {
			// Printer hvis tur det er.
			console.printWhosTurn(turn);
			// Løkken kører så længe der ikke bliver skrevet "roll" eller "" i
			// konsollen.
			do {
				// Sørger for koden ikke køres i første gennemkørsel.
				if (!consoleInput.equals("unassigned")) {
					// Printer beskeder til spilleren udfra input
					if (turn == 0)
						console.inputHandler(consoleInput, p1, turn);
					else
						console.inputHandler(consoleInput, p2, turn);
				}
				// Henter en ny command fra brugeren.
				consoleInput = console.getCommand();
			} while (!(consoleInput.equals("roll") || consoleInput.equals("")));

			// Sætter console inputtet til "unassigned".
			consoleInput = "unassigned";

			// Spiller en tur for en af spillerne
			if (turn == 0)
				playTurn(p1, console);
			else
				playTurn(p2, console);

			// Sætter hvis tur det er
			turn = (turn + 1) % 2;

			// Tjekker om spillet er blevet vundet. Hvis det er vundet, går man
			// ud af loopet.
			if (gameWon)
				break;

		}
		// Skifter til den som har vundet.
		turn = (turn + 1) % 2;

		// Fortæller hvem der har vundet.
		if (turn == 0)
			console.gameEnd(p1, turn);
		else
			console.gameEnd(p2, turn);
		console.closeScanner();

	}

	/**
	 * Spiller en tur i spillet.
	 */
	public static void playTurn(Player p, TUI console) {
		// Gemmer spillerens score i en variabel før han slår med terningerne
		int lastScore = p.getScore();

		// Slår med terningerne
		p.rollDiceCup();
		console.printTurn(p, turn);


		// Hvis en spiller slår to ens får spilleren en ekstra tur.
		if (p.getNewRoll1() == p.getNewRoll2()) {
			// Hvis en spiller slår to seksere, to runder i træk, så vinder
			// spilleren.
			if (p.getNewRoll1() == 6 && p.getNewRoll1() == p.getLastRoll1() && p.getNewRoll2() == p.getLastRoll2()) {
				console.printPairOfSixes(turn);
				System.out.println("");
				gameWon = true;
				return;
			}
			if (p.getScore() == 40) {
				// Hvis spillerens forrige point var 40 i forrige tur
				if (lastScore == 40) {
					// Hvis en spiller slår to ens, så vinder spilleren
					gameWon = true;
					return;
				}

			}

			// Hvis en spiller slår to 1'ere, så sættes spillerens point til
			// 0.
			if (p.getNewRoll1() == 1 && p.getNewRoll2() == 1) {
				console.printLosePoints(turn);
				p.resetScore();
			}
			console.printExtraTurn(turn);
			// Spilleren får en ekstra tur
			turn = (turn + 1) % 2;
			

			gameWon = false;
		}
		// Hvis en spiller har opnået 40 point
		if (p.getScore() == 40) {
			console.printHasFourty(turn);

		}
		return;
	}
}