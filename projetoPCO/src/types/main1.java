package types;

import java.util.ArrayList;
import java.util.Arrays;

import types.BinaryColour;
import java.util.List;

public  class main1 {
	
	private static BullsAndCowsCode codeToTest1;
	private static BullsAndCowsCode codeToTest2;
	
	public static void main (String[] args) {
	
		
		ArrayList<BinaryColour> start = new ArrayList<BinaryColour>();

		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.WHITE);
		
		codeToTest1 = new BullsAndCowsCode(start);
		
		ArrayList<BinaryColour> start2 = new ArrayList<BinaryColour>();
		
		start2.add(BinaryColour.BLACK);
		start2.add(BinaryColour.BLACK);
		start2.add(BinaryColour.BLACK);
		start2.add(BinaryColour.BLACK);
		start2.add(BinaryColour.BLACK);
		start2.add(BinaryColour.BLACK);//sim
		
		codeToTest1 = new BullsAndCowsCode(start);
		codeToTest2 = new BullsAndCowsCode(start2);

        // expected = {1, 2};
        int[] result = codeToTest1.howManyCorrect(codeToTest2);

       
        System.out.print(Arrays.toString(result));
	}

}
