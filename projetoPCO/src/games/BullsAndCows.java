package games;

import types.Colour;

public class BullsAndCows extends AbstractMastermindGame {

	public BullsAndCows(int seed, int size, Colour[] colours) {
		super(seed, size, colours);
		// TODO Auto-generated constructor stub
		}
		
	@Override
	public boolean isRoundFinished() {
		// TODO Auto-generated method stub
		if (wasSecretRevealed() || MAX_TRIALS == getNumberOfTrials()) {
			return true;
		}
		
		return false;
	}

	@Override
	public int score() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateScore() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//FALTA COLOUR HINT REIMPLEMENRZ
}
