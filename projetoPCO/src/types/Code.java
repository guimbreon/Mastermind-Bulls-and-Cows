package types;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

//All documentation is needed.

public class Code implements Cloneable {

    // Stores the list of Colours representing the code.
    private final List<Colour> code;

    /**
     * Constructs a Code object with the given list of Colours.
     * The list can include any subtype of Colour.
     *
     * @param code the list of Colours (or its subtypes) representing the code.
     *             The list is defensively copied to ensure immutability.
     */
    public Code(List<? extends Colour> code) {
//    	É PRECISO SER DEFENSIVO???
//        if (code == null) {
//            throw new IllegalArgumentException("Code list cannot be null.");
//        }
        this.code = new ArrayList<>(code);
    }

    
    /**
     * Returns a copy of the list of Colours representing this code.
     *
     * @return a new list containing the Colours of this code.
     */
	public List<Colour> getCode() {
		return new ArrayList<>(code); 
	}


    /**
     * Returns the length of the code sequence.
     *
     * @return the number of Colours in the code.
     */
    public int getLength() {
        return code.size();
    }

	public int[] howManyCorrect(Code other) {
		if(other == null || other.getLength() != this.getLength()) {
    		throw new IllegalStateException("Code lengths must match for ");
		}
		
		int correctPositions = 0;
		int correctColour = 0;
		
		List<Colour> unmatchedThis = new ArrayList<>();
		List<Colour> unmatchedOther = new ArrayList<>();
				
		for(int i = 0; i < this.getLength();i++) {
			if(this.code.get(i).equals(other.code.get(i))) {
				correctPositions++;		
			}else {
				unmatchedThis.add(this.code.get(i));
				unmatchedOther.add(other.code.get(i));
			}
		}
		
		
		for(Colour c: unmatchedThis) {
			if(unmatchedOther.contains(c)) {
				correctColour++;
				unmatchedOther.remove(c);
			}
		}
		return new int[]{correctPositions, correctColour}; 
	}
	   /**
     * Returns a textual representation of this Code in the format [c1, c2, c3, ...].
     *
     * @return a String representation of the Code.
     */
    @Override
    public String toString() {
        return code.toString();
    }
    
    /**
     * Creates and returns a copy of this Code.
     *
     * @return a new Code object that is a copy of this instance.
     */
    @Override
    public Code clone() {
    	if(this.code == null) {
    		throw new IllegalStateException("Code instance has null code");
    	}
    	return new Code(this.code);
    }
    
    /**
     * Compares the Code object to the specified object for equality.
     *
     * @param obj the object to compare with this Code instance.
     * @return true if the specified object is equal to this Code instance,
     *         false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
    	if (this == obj) {
    		return true;
    	}
    	if (obj == null || obj.getClass() != this.getClass()) {
    		return false;
    	}
    	Code other = (Code) obj;
    	return Objects.equals(this.code, other.code);
    	
    }
    
    


}
