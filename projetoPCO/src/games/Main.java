package games;

import java.util.ArrayList;

import java.util.Scanner;

import types.*;



public class Main {
	protected static Scanner scanner = new Scanner(System.in);
	protected static boolean stillPlaying = true;

	public static void main(String[] args) {
		
		
		while(stillPlaying) {
			System.out.println("Which gamemode do you want to play?\n	1-MultiColour Mastermind\n	2-BullsAndCows");
			String gameMode = scanner.nextLine();
			
			
			
			ClearConsole();
			
			
			switch(gameMode){
				case "1":
					System.out.println("\nWELCOME TO MULTICOLOUR MASTERMIND!!!\n");
					
					MultiColourMastermindGame multiColourGame = new MultiColourMastermindGame(3, 5, MultiColour.values());
					multiColourGame.startNewRound();
					
					while(!multiColourGame.isRoundFinished()) {
						Code code = createCode(MultiColour.values());
						multiColourGame.play(code);
					}
					
					
					keepPlaying();
					break;
				case "2":
					System.out.println("\nWELCOME TO MULTICOLOUR MASTERMIND!!!");
					
					BullsAndCows binaryGame = new BullsAndCows(3, 5, BinaryColour.values());
					binaryGame.startNewRound();
					
					
					createCode(BinaryColour.values());
					
					
					keepPlaying();
					
					
					break;
				default:
					System.out.println("\nOh...you probably entered a number for a non-existing gamemode, try again!\n\n(PLEASE PRESS ENTER TO CONTINUE)\n");
					scanner.nextLine();
					ClearConsole();
			}
		}		
		
		System.out.println("THANKS FOR PLAYING MASTERMIND GAME!");
	}
	
	
	private static void ClearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }	
	}
	
	
	private static void keepPlaying() {

		System.out.println("Do you wish to keep playing or no?\n	1-Yes\n	2-No");
		String keepPlay = scanner.nextLine();

		//just to differenciate the way of handling an int
		if(keepPlay == "2") {
			stillPlaying = false;				
		}
		ClearConsole();
		
	}
	
	
	private static Code createCode(Colour[] availColours) {
		String allColours = "";
		
		//colors
		for (Colour colour : availColours) {
	        allColours += colour.toString() + " - " + getColorName(colour) + "\n";
	    }
		
		
		System.out.println("What is your guess for the secret code??\n	Information: The available colours are:");
		System.out.println(allColours);
		System.out.println("	Let's say you want to type a code with the colors Blue, Red, Red and then Pink. You will type in the terminal: 'B R R P'\n");


		String futureCode = scanner.nextLine();


		String[] splitCode = futureCode.split(" ");
		ArrayList<MultiColour> attempt = 	transformToColors(splitCode);
		
		
		return new Code(attempt);				
	}


	private static String getColorName(Colour colour) {
		
	    if (colour instanceof MultiColour) {
	    	return ((MultiColour) colour).name();
	    	
	    } else if (colour instanceof BinaryColour) {
	    	return ((BinaryColour) colour).name();
	    	
	    }
	    return "Unknown Color";//just to check
	}
	
	
	private static ArrayList<MultiColour> transformToColors(String[] stringColors) {
        
		ArrayList<MultiColour> result = new ArrayList<>();
        for (String colorCode : stringColors) {
            for (MultiColour colour : MultiColour.values()) {
                if (colour.toString().equals(colorCode)) {
                    result.add(colour);
                    break;
                }
            }
        }
        return result;
    }
}