package games;

import types.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractMastermindGame implements MastermindGame {

    // Attributes needed for the game logic
    protected int currentScore; // Stores the current score of the game
    protected List<Code> attempts; //VERIFY IF ITS REALLY CODE
    protected int numberOfTrials; // Tracks the number of trials made in the current round
    protected boolean secretRevealed; // Indicates if the secret code has been revealed
    protected Colour[] colours; // Array of colours used in the game
    protected int size; // Size of the secret code
    protected int seed; // Seed
    protected Random random; // Random generator for secret code and hints

    // Constructor for the abstract class
    public AbstractMastermindGame(int seed, int size, Colour[] colours) {
        this.seed = seed;
        this.size = size;
        this.colours = colours;
        this.random = new Random(seed);
        this.attempts = new ArrayList<>();
        this.currentScore = 0;
        this.numberOfTrials = 0;
        this.secretRevealed = false;
    }
    // Abstract method to calculate the current score
    public abstract int score();
    
    // Abstract method to check if the round is finished
    public abstract boolean isRoundFinished();

    // Abstract method to update the score when a round is finished
    public abstract boolean updateScore();
    
    
    
    // Method to play a trial with a given code and check the result
    @Override
    public void play(Code x) {
        // Implementation for playing a trial (can be customized by subclasses)
    }


    // Method to start a new round of the game
    @Override
    public void startNewRound() {
        // Implementation for starting a new round (can be customized by subclasses)
    }

    // Method to get the best trial (highest score in terms of A and B values)
    @Override
    public Code bestTrial() {
        return null; // Returns the best trial (this can be implemented by subclasses)
    }

    // Method to provide a colour hint for the player
    @Override
    public Colour hint() {
        // Implementation for providing a hint (can be overridden by subclasses)
        return null;
    }

    // Method to get the number of trials made in the current round
    @Override
    public int getNumberOfTrials() {
        return numberOfTrials; // Returns the number of trials made
    }



    // Method to check if the secret code has been revealed
    @Override
    public boolean wasSecretRevealed() {
        return secretRevealed; // Returns whether the secret code is revealed
    }


    // Method to return a textual representation of the game state
    @Override
    public String toString() {
        return null; // Returns a string representation of the game (can be overridden by subclasses)
    }
}
