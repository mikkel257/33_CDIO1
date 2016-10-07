package game;

import java.util.Scanner;

public class TUI {

	// Get Command - Indlæsning af Command.

	private Scanner sc = new Scanner(System.in);

	public String getCommand() {
		String command = sc.nextLine();
		command = command.toLowerCase();
		return command;
	}
	/** Pritning af en kort introduktion til spilleren.
	 * Printer samtidig "help", som er en liste over tilgængelige kommandoer.
	 */
	public void intro() {
		System.out.println("Welcome to the dice game. The available commands are as follows: ");
		inputHandler("help", null, 0);
		inputHandler("rules", null, 0);
	}

	/** Vores inputHandler håndterer brugerens input,
	 * og giver et svar baseret på brugerens input.
	 */
	public String inputHandler(String command, Player p, int turn) {

		// Indlæsning af Scanner.
		//"help" kommando og output
		if (command.equals("help")) {
			System.out.println("'Roll' - Roll the dices in the dice cup.");
			System.out.println("'Score' - Show your current score.");
			System.out.println("'Last' - Show your last dicethrow (combined value | Dice 1 | Dice 2)");
			System.out.println("'Player' - Show whose turn it is");
			System.out.println("'Rules' - Print a list of the game rules");
			System.out.println("'Help' - Print a list of all available commands");
			System.out.println();
		}
		//"rules" kommando og output
		else if (command.equals("rules"))
		{
			System.out.println("The objective is to be the first player to gather 40 points in total and afterwards roll a pair, by rolling two dices");
			System.out.println("The rules are as follows:");
			System.out.println("- By rolling a pair gives an extra turn.");
			System.out.println("- By rolling a pair of ones, you lose all your points.");
			System.out.println("- By rolling a pair of sixes twice in a row, you win the game.");
			System.out.println();
		}
		//"score" kommando og output
		else if (command.equals("score")) { // Viser nuværrende score.
			System.out.println("Player " + ++turn + " your score is " + p.getScore());
			System.out.println();
		}
		//"last" kommando og output
		else if (command.equals("last")) {
			if(p.getNewRoll1()==0){
				System.out.println("You have not rolled the dice yet.");
				System.out.println();}
			else{
				System.out.println("Player " + ++turn + ", your last dice values were: "
						+ (p.getNewRoll1() + p.getNewRoll2()) + " | " + p.getNewRoll1()
						+ " + " + p.getNewRoll2());
				System.out.println();}
		}
		//"player" kommando og output

		else if (command.equals("player")) {
			System.out.println("It's currently player: " + ++turn + "'s turn.");
			System.out.println();
		} else {
			//Default kommando's output
			System.out.println("Command not recognized. Please insert new command.");
			System.out.println();
		}
		return command;
	}
	/** Metode til at printe at genkende vinderen af spillet,
	 * og printe et output.
	 */
	public void gameEnd(Player p, int turn) {
		System.out.println("Congratulations, " + "Player" + ++turn + ". You have won the game!");
		sc.close();
		System.out.println();
	}

	/** Metode til at genkende spilleren,
	 * og printe spillerens øjenværdier, og nye score.
	 */
	public void printTurn(Player p, int turn) {
		System.out.println("You rolled: "+p.getNewRoll1()+" and "+p.getNewRoll2());
		System.out.println("Your new score is: "+p.getScore()+"\n");

	}

	/** Metode til at bestemme hvilken
	 * en af spillernes tur det er.
	 */
	public void printWhosTurn(int turn) {
		System.out.println("It's now player "+ ++turn+"'s turn.");
	}
	/**
	 * Fortæller at du har mistet alle dine point.
	 * @param turn
	 */
	public void printLosePoints(int turn) {
		System.out.println("Player "+ ++turn+" rolled two ones and loses all his points.");
		System.out.println();
	}
	/**
	 * Fortæller at du har fået en ekstra tur.
	 * @param turn
	 */
	public void printExtraTurn(int turn) {
		System.out.println("Player "+ ++turn+" rolled a pair, and gets an extra turn.");
		System.out.println();
	}
	/**
	 * Fortæller at du rullet par 6 og derfor har vundet.
	 */
	public void printPairOfSixes(int turn) {
		System.out.println("Player "+ ++turn+" rolled two pairs of sixes in a row.");
		System.out.println();
	}
	/**
	 * Fortæller at du har opnået de 40 point og dermed kun skal rulle et par for at vinde.
	 */
	public void printHasFourty(int turn) {
		System.out.println("Player "+ ++turn+" has achieved 40 points. Player "+ turn+" must now roll a pair to win.");
		System.out.println();
	}
	//lukker keyboard scanner
	public void closeScanner(){
		sc.close();

	}


}