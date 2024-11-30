package games;


import java.util.Scanner;

import types.*;

public class Main {
	protected static Scanner scanner = new Scanner(System.in);
	protected static boolean stillPlaying = true;

	public static void main(String[] args) {
		
		
		while(stillPlaying) {
			System.out.println("Which gamemode do you want to play?\n	1-MultiColour Mastermind\n	2-BullsAndCows");
			int gameMode = scanner.nextInt();
			
			ClearConsole();
			
			switch(gameMode){
				case 1:
					System.out.println("\nWELCOME TO MULTICOLOUR MASTERMIND!!!");
					
					MultiColourMastermindGame multiColourGame = new MultiColourMastermindGame(3, 5, MultiColour.values());
					multiColourGame.startNewRound();

					createCode(MultiColour.values());
					
					keepPlaying();
					break;
				case 2:
					System.out.println("\nWELCOME TO MULTICOLOUR MASTERMIND!!!");
					
					BullsAndCows binaryGame = new BullsAndCows(3, 5, BinaryColour.values());
					binaryGame.startNewRound();

					createCode(BinaryColour.values());
					
					keepPlaying();
					break;
				default:
					System.out.println("\nOh...you probably entered a number for a non-existing gamemode, try again!\n\n");
					scanner.nextLine();
			}
		}		
	}
	
	private static void ClearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
		
	}
	
	private static void keepPlaying() {
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Do you wish to keep playing or no?\n	1-Yes\n	2-No");
		int keepPlay = scanner.nextInt();
		
		//just to differenciate the way of handling an int
		if(keepPlay == 2) {
			stillPlaying = false;				
		}
		ClearConsole();
		
	}
	
	private static Code createCode(Colour[] availColours) {
		String allColours = "";
		//colors
		for(Colour colour: availColours) {
			allColours += colour.toString() + "-" + ((MultiColour)colour).name() + "\n";
		}
		System.out.println(allColours);
		
		System.out.println("What is your guess for the secret code??\n	Information: The available colours are: ");
		String futureCode = scanner.nextLine();
		
		return null;		
	}

}
