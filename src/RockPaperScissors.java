import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import business.Game;

public class RockPaperScissors {
	public static void main(String[] args) throws FileNotFoundException {
	Scanner scanner = new Scanner(System.in);	
	while (true) {
		String playersChoice = "";
		
		
		boolean validChoice = false;
		while(!validChoice) {
			System.out.println("Make your move by typing in rock, paper, or scissors");
			playersChoice = scanner.nextLine();	
			validChoice = Game.isValidChoice(playersChoice);
			
			if (!validChoice) {
				System.out.println("Please enter a valid choice");
			}
		}
		String computersChoice = Game.generateComputerChoice();
		System.out.println("Computer plays: " + computersChoice);
		
		String result = Game.playGame("Casey", playersChoice, "Computer", computersChoice);
		System.out.println(result);
		
		System.out.println("Would you like to play again? (y/n)");
		String playAgain = scanner.nextLine();
		
		if (!playAgain.equalsIgnoreCase("y")) {
			break;
		}
	
		}
	}
}
