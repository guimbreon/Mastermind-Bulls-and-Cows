package games;

import types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractMastermindGame implements MastermindGame{
	
    private final Random random;
    private final int size;
    private final Colour[] colours;

	public AbstractMastermindGame(int seed, int size, Colour[] colours) {
		this.random = new Random(seed);
		this.size = size;
        this.colours = colours;		
	}
	
	
}

