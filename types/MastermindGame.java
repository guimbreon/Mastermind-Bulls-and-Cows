package types;


//Documentation needed.

public interface MastermindGame {
	
	public static final int MAX_TRIALS = 25;
	
	/**
     * Plays a trial with the given code and checks the result.
     *
     * @param x The code provided by the player.
     */
	public void play(Code trial);
	
	/**
     * Determines if the current round is finished.
     *
     * @return true if the round is finished; false otherwise.
     */
	public boolean isRoundFinished();
	
	/**
     * Starts a new round by generating a new secret code and resetting the trial counter.
     */
	public void startNewRound();
	
	/**
     * Returns the best trial made in terms of the number of correct colours and positions (A and B values).
     *
     * @return The best trial, or null if no trials have been made.
     */
	public Code bestTrial();
	
	/**
     * Provides a hint by returning a random colour from the secret code.
     *
     * @return A random colour from the secret code.
     */
	public Colour hint();

	/**
     * Returns the number of trials made in the current round.
     *
     * @return The number of trials.
     */
	public int getNumberOfTrials();
	
	/**
     * Returns the current score of the game.
     *
     * @return The current score.
     */
	public int score();
	
	/**
     * Checks if the secret code has been revealed.
     *
     * @return true if the secret code is revealed; false otherwise.
     */
	public boolean wasSecretRevealed();

}
