package types;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import games.MultiColourMastermindGame;

public  class mainGui {
	
	private static BullsAndCowsCode codeToTest1;
	private static BullsAndCowsCode codeToTest2;
	
	public static void main (String[] args) {

        ArrayList<MultiColour> attempt1 = new ArrayList<>();
        attempt1.add(MultiColour.BLUE);
        attempt1.add(MultiColour.RED);
        attempt1.add(MultiColour.BLUE);
        attempt1.add(MultiColour.GREEN);
        attempt1.add(MultiColour.BLUE);

        Code code1 = new Code(attempt1);
        
        ArrayList<MultiColour> attempt2 = new ArrayList<>();
        attempt2.add(MultiColour.RED);
        attempt2.add(MultiColour.YELLOW);
        attempt2.add(MultiColour.GREEN);
        attempt2.add(MultiColour.BLUE);
        attempt2.add(MultiColour.PINK);
        Code code2 = new Code(attempt2);

        ArrayList<MultiColour> attempt3 = new ArrayList<>();
        attempt3.add(MultiColour.PINK);
        attempt3.add(MultiColour.ORANGE);
        attempt3.add(MultiColour.BLUE);
        attempt3.add(MultiColour.RED);
        attempt3.add(MultiColour.YELLOW);
        Code code3 = new Code(attempt3);

		
		
		MultiColourMastermindGame jogo = new MultiColourMastermindGame(3, 5, MultiColour.values());
	
		
		
		jogo.startNewRound();
		

		jogo.play(code1);
		jogo.play(code2);
		jogo.play(code3);
		jogo.play(code3);
		jogo.play(code3);

		System.out.println(jogo.hint());
		
		
//		ArrayList<BinaryColour> start = new ArrayList<BinaryColour>();
//
//		start.add(BinaryColour.BLACK);
//		start.add(BinaryColour.WHITE);
//		start.add(BinaryColour.WHITE);
//		start.add(BinaryColour.WHITE);
//		start.add(BinaryColour.WHITE);
//		start.add(BinaryColour.WHITE);
//		
//		codeToTest1 = new BullsAndCowsCode(start);
//		
//		ArrayList<BinaryColour> start2 = new ArrayList<BinaryColour>();
//		
//		start2.add(BinaryColour.BLACK);
//		start2.add(BinaryColour.BLACK);
//		start2.add(BinaryColour.BLACK);
//		start2.add(BinaryColour.BLACK);
//		start2.add(BinaryColour.BLACK);
//		start2.add(BinaryColour.BLACK);
//		
//		codeToTest1 = new BullsAndCowsCode(start);
//		codeToTest2 = new BullsAndCowsCode(start2);
//
//        // expected = {1, 2};
//        int[] result = codeToTest1.howManyCorrect(codeToTest2);
//
//       
//        System.out.print(Arrays.toString(result));
	}

}
