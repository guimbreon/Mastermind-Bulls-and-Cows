package types;

import java.util.List;



public class MultiColourMastermindGame extends AbstractMastermindGame{
	
	protected int numberOfHints; // Stores the current number of Hints
	
	/**
     * Constructs a new instance of the MultiColourMastermindGame.
     * 
     * @param seed    the random seed used to generate the secret code.
     * @param size    the number of positions in the secret code.
     * @param colours an array of possible colors for the code.
     */
	
	public MultiColourMastermindGame(int seed, int size, Colour[] colours) {
		super(seed, size, colours);
	}

	
    /**
     * Calculates and returns the current score of the game.
     * 
     * @return the current score.
     */
	@Override
	public int score() {
		return currentScore;
	}

	 /**
     * Determines if the current round of the game is finished.
     * A round is considered finished if the secret code was revealed or
     * the maximum number of trials has been reached.
     * 
     * @return {@code true} if the round is finished; {@code false} otherwise.
     */
	@Override
	public boolean isRoundFinished() {
		if (wasSecretRevealed() || MAX_TRIALS == getNumberOfTrials()) {
			return true;
		}
		
		return false;
	}
	
	/**
     * Updates the player's score based on the number of trials and hints used.
     * The scoring logic assigns higher points for fewer trials and hints.
     * 
     * @return {@code true} if the score was successfully updated.
     */
	@Override
    public boolean updateScore() {
        if (getNumberOfTrials() <= 2) {        	
            currentScore += 100 / (numberOfHints + 1); }
        else if (getNumberOfTrials() <= 5) {
            currentScore += 50 / (numberOfHints + 1); }
        else {
            currentScore += 20 / (numberOfHints + 1); }

        return true;
    }
	
	/**
     * Provides a hint for the current game state.
     * The hint is generated using the parent method and increments the hint counter.
     * 
     * @return the color hint generated.
     */
	@Override
    public Colour hint() {
		Colour newHint = super.hint();  
		this.numberOfHints += 1; 
        return newHint; 
    }

}
