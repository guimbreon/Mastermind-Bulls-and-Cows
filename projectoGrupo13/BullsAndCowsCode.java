package types;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCowsCode extends Code{
	
	/**
     * Constructs a BullsAndCowsCode instance with a given list of BinaryColour elements.
     *
     * @param code the list of BinaryColour elements representing the code.
     */
	public BullsAndCowsCode(List<BinaryColour> code) {
		super(code);
	}
	
	/**
     * Compares this code with another code and calculates:
     * - The number of correct colors in the correct positions.
     * - The number of correct colors in incorrect positions.
     *
     * @param other the code to compare with.
     * @return an integer array where:
     *         - The first element is the number of correct colors in the correct positions.
     *         - The second element is the number of correct colors in incorrect positions.
     * @throws IllegalStateException if the provided code is null or has a different length from this code.
     */
	public int[] howManyCorrect(Code other) {
		if(other == null || other.getLength() != this.getLength()) {
    		throw new IllegalStateException("Code lengths must match for ");
		}
		
		int a = 0; //a. - number of correct colors		
		
		List<Colour> segredo_unmatched = new ArrayList<>();
		List<Colour> tentativa_unmatched = new ArrayList<>();
				
		for(int i = 0; i < this.getLength();i++) {
			if(this.code.get(i).equals(other.code.get(i))) {
				a++;		
			}else {
				segredo_unmatched.add(this.code.get(i)); //adds the elems that are not correct
				tentativa_unmatched.add(other.code.get(i)); //adds the elems that are not correct
			}
		}
		
		int nMaxB = 0; //smallest num of wrong occurencies of "B" between secret and trial
		int nMaxW = 0; //smallest num of wrong occurencies of "W" between secret and trial
		
		for(Colour c: segredo_unmatched) {
			if (c.toString() == "B") {
				nMaxB++;
			} else {
				nMaxW++;
			}
		}
		
		int nMaxB2 = 0;
		int nMaxW2 = 0;
		for(Colour c: tentativa_unmatched) {
			if (c.toString() == "B" ) {
				nMaxB2++;
			} else {
				nMaxW2++;
			}
		}
		
		if (nMaxB2 < nMaxB) {
			nMaxB = nMaxB2;
		}
		if (nMaxW2 < nMaxW) {
			nMaxW = nMaxW2;
		}
		
		return new int[]{a, nMaxB + nMaxW}; 
	}
	

}
