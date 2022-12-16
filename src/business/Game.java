package business;

import java.io.FileNotFoundException;
import java.util.Random;

import data.WinTracker;

public class Game {
	public static boolean isValidChoice(String choice) {
		if (choice.equalsIgnoreCase("rock") || choice.equalsIgnoreCase("paper") || choice.equalsIgnoreCase("scissors")) {
			return true;
		}
		return false;
	}
	public static String playGame(String player1Name, String player1Choice, String player2Name, String player2Choice) throws FileNotFoundException {
		//String result = "";
		
		if (player1Choice.equalsIgnoreCase(player2Choice)) {
			return "Tie!";
		} 
		
		String winnerName = "";
		
		if (player1Choice.equalsIgnoreCase("rock")) {
			if (player2Choice.equalsIgnoreCase("paper")) {
				winnerName = player2Name;
				
			} else if (player2Choice.equalsIgnoreCase("scissors")) {
				winnerName = player1Name;
			}
		}	
			
		else if (player1Choice.equalsIgnoreCase("paper")) {
				if (player2Choice.equalsIgnoreCase("rock")) {
					winnerName = player1Name;
					
			} else if (player2Choice.equalsIgnoreCase("scissors")) {
					winnerName = player2Name;
			}	
		}
		
		else if (player1Choice.equalsIgnoreCase("scissors")) {
			if (player2Choice.equalsIgnoreCase("paper")) {
				winnerName = player1Name;
				
			} else if (player2Choice.equalsIgnoreCase("rock")) {
				winnerName = player2Name;
			}
		} 
		WinTracker.updateWinRecord(winnerName);
		
		return winnerName + " Wins!";
	}
	public static String generateComputerChoice() {
		String[] choiceList = {"rock", "paper", "scissors"};
		String computersChoice = choiceList[new Random().nextInt(choiceList.length)]; 
		
		return computersChoice;
	}
}
	