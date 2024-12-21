package types;

import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;



public class Main {
	protected static Scanner scanner = new Scanner(System.in);
	protected static boolean stillPlaying = true;
	protected static int seed;

	
	 /**	
     * Main entry point of the program. Manages the game selection, initialization, and loops.
     * 
     * @param args Command-line arguments (not used).
     */
	public static void main(String[] args) {
		
		
		while(stillPlaying) {
			System.out.println("Which gamemode do you want to play?\n	1-MultiColour Mastermind\n	2-BullsAndCows");
			String gameMode = scanner.nextLine();
			
			Random random = new Random();
			
			seed = random.nextInt(8052004);
			int numberOfTrials;
			
			clearConsole();
			int diff;
			switch(gameMode){
				case "1":
					diff = gameDifficulty();
					System.out.println("\nWELCOME TO MULTICOLOUR MASTERMIND!!!\n");
					
					MultiColourMastermindGame multiColourGame = new MultiColourMastermindGame(seed, diff, MultiColour.values());
					
					//while the round isnt finished
					while(!multiColourGame.isRoundFinished()) {
						numberOfTrials= multiColourGame.numberOfTrials;
						clearConsole();
						if(numberOfTrials >= 1) {
							System.out.println(multiColourGame.toString() + "\n");
							
							if(numberOfTrials % 3 == 0) {
								//every three rounds it'll ask if the user wants a hint
								System.out.println("Do you want some hints? Type 'HINT' for a little help!\n But beware, it'll decrease your points in the end!\n");
								String hint = scanner.nextLine();
								
								clearConsole();
								System.out.println(multiColourGame.toString());
								if(hint.equals("HINT")) {
									System.out.println("There is the color '" + getColorName(multiColourGame.hint()) + "' in the secret Code!\n");
								}
							}
						}
						Code code = createCode(MultiColour.values(), "multiColour");
						multiColourGame.play(code);
						clearConsole();
					}

					clearConsole();
					//if the user wins
					if(multiColourGame.secretRevealed) {
						System.out.println("CONGRATS YOU HAVE GUESSED THE CODE CORRECTLY!!!");
						System.out.println(multiColourGame.toString());
					}else {
						//if they lose
						System.out.println("oh...look like you didn't win this time :(");
						System.out.println("Your best trial was: " + multiColourGame.bestTrial());
						System.out.println("And secret code is: " + multiColourGame.secretCode + "\n");
					}
								
					keepPlaying();
					break;
				case "2":
					diff = gameDifficulty();
					clearConsole();
					System.out.println("\nWELCOME TO MULTICOLOUR MASTERMIND!!!");
					
					BullsAndCows binaryGame = new BullsAndCows(seed, diff, BinaryColour.values());
					
					
					while(!binaryGame.isRoundFinished()) {
						numberOfTrials= binaryGame.numberOfTrials;
						if(numberOfTrials >= 1) {
							System.out.println(binaryGame.toString());
							
							if(numberOfTrials % 3 == 0) {
								//every three rounds it'll ask if the user wants a hint
								System.out.println("Do you want some hints? Type 'HINT' for a little help!\n But beware, it'll decrease your points in the end!\n");
								String hint = scanner.nextLine();

								clearConsole();
								System.out.println(binaryGame.toString());
								if(hint.equals("HINT")) {
									System.out.println("There is the color '" + getColorName(binaryGame.hint()) + "' in the secret Code!\n");
								}
							}

						}
						Code code = createCode(BinaryColour.values(), "binary");
						binaryGame.play(code);
						clearConsole();
					}

					clearConsole();
					//if the user wins
					if(binaryGame.secretRevealed) {
						System.out.println("CONGRATS YOU HAVE GUESSED THE CODE CORRECTLY!!!");
						System.out.println(binaryGame.toString());
					}else {
						//if they lose
						System.out.println("oh...look like you didn't win this time :(");
						System.out.println("Your best trial was: " + binaryGame.bestTrial());
						System.out.println("And secret code is: " + binaryGame.secretCode + "\n");
					}
					
					
					keepPlaying();
					
					
					break;
				default:
					System.out.println("\nOh...you probably entered a number for a non-existing gamemode, try again!\n\n(PLEASE PRESS ENTER TO CONTINUE)\n");
					scanner.nextLine();
					clearConsole();
			}
		}		
		System.out.println("THANKS FOR PLAYING MASTERMIND GAME!");
	}
	
	
	/**
	 * Prompts the user to select the game difficulty (Easy, Medium, or Hard).
	 * Returns the corresponding number of pins: 4 for Easy, 5 for Medium, 6 for Hard.
	 * 
	 * @return The number of pins for the selected difficulty.
	 */
	private static int gameDifficulty() {
		
		while(true) {
			clearConsole();
			System.out.println("Choose the game difficulty:\n\t1-Easy(4 pins)\n\t2-Medium(5 pins)\n\t3-Hard(6 pins)");
			String diff = scanner.nextLine();
				
			if (diff.equals("1")) {
			    return 4;
			} else if (diff.equals("2")) {
			    return 5;
			} else if (diff.equals("3")) {
			    return 6;
			}else {
				System.out.println("\nOh...you probably entered a number for a non-existing game difficulty, try again!\n\n(PLEASE PRESS ENTER TO CONTINUE)\n");
				scanner.nextLine();
			}
		}
		
	}
	
	/**
     * Clears the console screen by printing blank lines.
     */
	private static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }	
	}
	
	
	/**
     * Handles the decision to keep playing or exit the game.
     * Updates the `stillPlaying` flag based on user input.
     */
	private static void keepPlaying() {

		while(true) {
			System.out.println("Do you wish to keep playing or no?\n	1-Yes\n	2-No");
			String keepPlay = scanner.nextLine();
			
			//just to differenciate the way of handling an int
			if(keepPlay.equals("1")) {
				stillPlaying = true;
				break;
			}else if(keepPlay.equals("2")) {
				stillPlaying = false;	
				break;			
			}else {
				System.out.println("\nOh...you probably entered a number for a non-existing option, try again!\n\n(PLEASE PRESS ENTER TO CONTINUE)\n");
				scanner.nextLine();
			}
			
		}		
	}
	
	
	 /**
     * Creates a `Code` object based on user input and available colors.
     * 
     * @param availColours The array of available colors for the game mode.
     * @param type         The type of game mode (e.g., "multiColour" or "binary").
     * @return A `Code` object representing the user's guess.
     */	
	private static Code createCode(Colour[] availColours, String type) {
		String allColours = "";
		
		//colors
		for (Colour colour : availColours) {
	        allColours += "\t" + colour.toString() + " - " + getColorName(colour) + "\n";
	    }
		
		
		System.out.println("What is your guess for the secret code??");
		System.out.println("\tInformation: The available colours are:");
		System.out.println(allColours);
		System.out.println("\tLet's say you want to type a code with the colors Blue, Red, Red and then Pink. You will type in the terminal: 'B R R P'\n");
				

		String futureCode = scanner.nextLine();
		


		String[] splitCode = futureCode.split(" ");
		if(type == "multiColour") {
			ArrayList<MultiColour> attempt = transformToColors(splitCode);
			return new Code(attempt);
		}else {
			ArrayList<BinaryColour> attempt = transformToBinary(splitCode);
			return new BullsAndCowsCode(attempt);
			
		}
	}

	/**
     * Transforms a string array of color codes into a list of `BinaryColour` objects.
     * 
     * @param stringColors An array of color codes entered by the user.
     * @return A list of `BinaryColour` objects.
     */
	private static ArrayList<BinaryColour> transformToBinary(String[] stringColors) {
		ArrayList<BinaryColour> result = new ArrayList<>();
        for (String colorCode : stringColors) {
            for (BinaryColour colour : BinaryColour.values()) {
                if (colour.toString().equals(colorCode)) {
                    result.add(colour);
                    break;
                }
            }
        }
        return result;
	}

	/**
     * Retrieves the name of a color as a string.
     * 
     * @param colour The color object (either `MultiColour` or `BinaryColour`).
     * @return The name of the color, or "Unknown Color" if not recognized.
     */
	private static String getColorName(Colour colour) {
		
	    if (colour instanceof MultiColour) {
	    	return ((MultiColour) colour).name();
	    } else if (colour instanceof BinaryColour) {
	    	return ((BinaryColour) colour).name();
	    }
	    return "Unknown Color";//just to check
	}
	
    /**
     * Transforms a string array of color codes into a list of `MultiColour` objects.
     * 
     * @param stringColors An array of color codes entered by the user.
     * @return A list of `MultiColour` objects.
     */
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