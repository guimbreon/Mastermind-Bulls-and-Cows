package types;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

import games.*;

public  class mainGui {
	
	private static BullsAndCowsCode codeToTest1;
	private static BullsAndCowsCode codeToTest2;
	private static MultiColourMastermindGame jogo;
	
	public static void main (String[] args) {
		MultiColour[] binario = MultiColour.values();

		MultiColourMastermindGame jogo = new MultiColourMastermindGame(2, 6, binario);

		ArrayList<MultiColour> trial = new ArrayList<MultiColour>();

		trial.add(MultiColour.PINK);
		trial.add(MultiColour.BLUE);
		trial.add(MultiColour.YELLOW);
		trial.add(MultiColour.RED);
		trial.add(MultiColour.GREEN);
		trial.add(MultiColour.BLUE);

		Code tentativa = new Code(trial);
		jogo.play(tentativa);
		jogo.play(tentativa);
		System.out.println("a");

		trial.removeLast();
		trial.add(MultiColour.ORANGE);

		tentativa = new Code(trial);

		jogo.play(tentativa);
		System.out.println("a");

		
		jogo.startNewRound();
		
		jogo.hint();

		int expected = 150;
		
		trial.clear();
		trial.add(MultiColour.BLUE);
		trial.add(MultiColour.GREEN);
		trial.add(MultiColour.RED);
		trial.add(MultiColour.BLUE);
		trial.add(MultiColour.YELLOW);
		trial.add(MultiColour.YELLOW);
		
		tentativa = new Code(trial);
		
		jogo.play(tentativa);
		System.out.println("a");

		int actual = jogo.score();

		System.out.println(expected + " " + actual);
	}

}
