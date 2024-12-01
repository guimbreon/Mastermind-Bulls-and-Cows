package types;

import java.util.List;
import java.util.ArrayList;

//All documentation is needed.

public class Code implements Cloneable{


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
		return null; 
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


}
