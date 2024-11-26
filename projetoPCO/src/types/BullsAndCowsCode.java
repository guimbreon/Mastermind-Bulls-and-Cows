package types;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCowsCode extends Code{
	
	public BullsAndCowsCode(List<BinaryColour> code) {
		super(code);
	}
	
	public int[] howManyCorrect(Code other) {
		if(other == null || other.getLength() != this.getLength()) {
    		throw new IllegalStateException("Code lengths must match for ");
		}
		
		int a = 0; //a. - num de cores certas no sitio certo
		
		
		List<Colour> segredo_unmatched = new ArrayList<>();
		List<Colour> tentativa_unmatched = new ArrayList<>();
				
		for(int i = 0; i < this.getLength();i++) {
			if(this.code.get(i).equals(other.code.get(i))) {
				a++;		
			}else {
				segredo_unmatched.add(this.code.get(i)); //adiciona apenas elementos que não estão certos
				tentativa_unmatched.add(other.code.get(i)); //adiciona apenas elementos que não estão certos
			}
		}
		
		int nMaxB = 0; //menor numero de ocorrências erradas "B" entre segredo e tentativa
		int nMaxW = 0; //menor numero de ocorrências erradas "W" entre segredo e tentativa
		
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
