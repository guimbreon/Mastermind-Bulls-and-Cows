package games;

import types.Colour;

public class MultiColourMastermindGame extends AbstractMastermindGame{

	public MultiColourMastermindGame(int seed, int size, Colour[] colours) {
		super(seed, size, colours);
	}

	@Override
	public int score() {
		// TODO Auto-generated method stub
		return 0;
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
	public boolean updateScore() {
		// TODO Auto-generated method stub
		return false;
	}

}
