package types;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCowsCode extends Code{
	
	public BullsAndCowsCode(List<BinaryColour> code) {
		super(code);
	}
	
	public int[] howManyCorrect(Code other) {
	    if (other == null || other.getLength() != this.getLength()) {
	        throw new IllegalStateException("Code lengths must match for comparison");
	    }

	    int a = 0; // Número de cores certas na posição certa
	    int unmatchedB = 0, unmatchedW = 0; // Contagem de ocorrências de "B" e "W" nas posições erradas

	    List<Colour> unmatchedSecret = new ArrayList<>();
	    List<Colour> unmatchedAttempt = new ArrayList<>();

	    // Verificar correspondências e coletar cores fora de posição
	    for (int i = 0; i < this.getLength(); i++) {
	        if (this.code.get(i).equals(other.code.get(i))) {
	            a++; // Contar cores na posição correta
	        } else {
	            unmatchedSecret.add(this.code.get(i));
	            unmatchedAttempt.add(other.code.get(i));
	        }
	    }

	    // Contar ocorrências de "B" e "W" diretamente das duas listas
	    for (Colour c : unmatchedSecret) {
	        if (c.toString().equals("B")) {
	        	unmatchedB++;
	        }
	        else {
	        	unmatchedW++;
	        }
	    }

	    for (Colour c : unmatchedAttempt) {
	        if (c.toString().equals("B")) {
	        	unmatchedB = Math.min(unmatchedB, unmatchedB);
	        }
	        else {
	        	unmatchedW = Math.min(unmatchedW, unmatchedW);
	        }
	    }

	    return new int[]{a, unmatchedB + unmatchedW}; // Retornar resultados
	}

	

}
