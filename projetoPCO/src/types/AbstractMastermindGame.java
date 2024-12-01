package types;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractMastermindGame implements MastermindGame {

    // Attributes needed for the game logic
    protected int currentScore; // Stores the current score of the game
    protected List<Object[]> attempts; //VERIFY IF ITS REALLY CODE
    protected int numberOfTrials; // Tracks the number of trials made in the current round
    protected boolean secretRevealed; // Indicates if the secret code has been revealed
    Code secretCode;
    protected Colour[] colours; // Array of colours used in the game
    protected int size; // Size of the secret code
    protected int seed; // Seed
    protected Random random; // Random generator for secret code and hints

    /**
     * Constructs a new Mastermind game instance.
     *
     * @param seed    The seed for random number generation.
     * @param size    The size of the secret code.
     * @param colours The array of colours available for the game.
     */
    public AbstractMastermindGame(int seed, int size, Colour[] colours) {
        this.seed = seed;
        this.size = size;
        this.colours = colours;
        this.random = new Random(seed);
        this.attempts = new ArrayList<>();
        this.currentScore = 0;
        this.numberOfTrials = 0;
        this.secretRevealed = false;
        startNewRound();
    }
    
    /**
     * Returns the current score of the game.
     *
     * @return The current score.
     */
    public abstract int score();
    
    /**
     * Determines if the current round is finished.
     *
     * @return true if the round is finished; false otherwise.
     */
    public abstract boolean isRoundFinished();

    /**
     * Updates the score when a round is finished.
     *
     * @return true if the score was updated successfully; false otherwise.
     */
    public abstract boolean updateScore();
    
    
    
    /**
     * Plays a trial with the given code and checks the result.
     *
     * @param x The code provided by the player.
     */
    @Override
    public void play(Code x) {
    	numberOfTrials += 1;
        if(!wasSecretRevealed()) {
        	addTrial(x);
         }
        
		if(x.equals(secretCode) && !wasSecretRevealed()) {
        	secretRevealed = true;
            updateScore();
        }
    }
    
    /**
     * Adds a trial to the attempts list if it does not already exist.
     *
     * @param x The code provided for the trial.
     */
    private void addTrial(Code x) {
    	boolean exists = false;
    	
	    for (Object[] attempt : attempts) {
	        Code existingCode = (Code) attempt[0]; //check code
	        if (existingCode.equals(x)) { //using equals to compare
	            exists = true;
	            break;
	        }
	    }
	    
	    if (!exists) {
	        int[] result = secretCode.howManyCorrect(x); 
	        Object[] trial = {x, result};
	        attempts.add(trial);
	    }
    }
        
    /**
     * Generates a new secret code for the game.
     */
    private void genSecretCode() {
        List<Colour> secretCodeList = new ArrayList<>();
        
		int randomIndex;
    	for(int i = 0; i < size; i++) {
    		randomIndex = random.nextInt(colours.length);
    		secretCodeList.add(colours[randomIndex]);
    	}
    	
    	
    	secretCode = new Code(secretCodeList);
    }
    
    /**
     * Generates a new secret code for the game.
     */
    private void genSecretCodeBinary() {
        List <BinaryColour> secretCodeList = new ArrayList<>();
        
		int randomIndex;
    	for(int i = 0; i < size; i++) {
    		randomIndex = random.nextInt(colours.length);
    		secretCodeList.add((BinaryColour) colours[randomIndex]);
    	}

		secretCode = new BullsAndCowsCode(secretCodeList);	    	
	      
    	
    }
    
    /**
     * Starts a new round by generating a new secret code and resetting the trial counter.
     */
    @Override
    public void startNewRound() {
    	if(colours.length == 2) {
        	genSecretCodeBinary();    		
    	}else {
        	genSecretCode();
    	}
    	this.numberOfTrials = 0;
    	this.secretRevealed = false;
    }

    /**
     * Returns the best trial made in terms of the number of correct colours and positions (A and B values).
     *
     * @return The best trial, or null if no trials have been made.
     */
    @Override
    public Code bestTrial() {
        if (attempts == null || attempts.isEmpty()) {
            return null; // Retorna null se a lista de tentativas estiver vazia
        }

        Code bestTrial = null;
        int bestA = -1; // Inicializa com valores impossíveis para facilitar a comparação
        int bestB = -1;

        for (Object[] attempt : attempts) {
        	int[] resultados = (int[]) attempt[1];  // Extraímos
        	Code codigo = (Code) attempt[0];
        	
            int[] correct = secretCode.howManyCorrect(codigo);
            int a = correct[0];
            int b = correct[1];

            // Atualiza o melhor teste baseado nas condições
            if (a > bestA || 
                (a == bestA && b > bestB) || 
                (a == bestA && b == bestB && (bestTrial == null || attempt.toString().compareTo(bestTrial.toString()) < 0))) {
                
                bestTrial = codigo;
                bestA = a;
                bestB = b;
            }
        }
        return bestTrial; // Retorna o melhor teste encontrado
    }



    /**
     * Provides a hint by returning a random colour from the secret code.
     *
     * @return A random colour from the secret code.
     */
    @Override
    public Colour hint() {
        int randomIndex;
        randomIndex = random.nextInt(secretCode.getLength());
        return secretCode.getCode().get(randomIndex);
    }

    /**
     * Returns the number of trials made in the current round.
     *
     * @return The number of trials.
     */
    @Override
    public int getNumberOfTrials() {
        return numberOfTrials; // Returns the number of trials made
    }



    /**
     * Checks if the secret code has been revealed.
     *
     * @return true if the secret code is revealed; false otherwise.
     */
    @Override
    public boolean wasSecretRevealed() {
        return secretRevealed; // Returns whether the secret code is revealed
    }
    
    /**
     * Returns the last 10 attempts made in the game.
     *
     * @param attempts The full list of attempts.
     * @return A list containing the last 10 attempts.
     */
    public static List<Object[]> getLast10Attempts(List<Object[]> attempts) {
        int size = attempts.size();
        int last10 = Math.max(size - 10, 0);  // Garante que o índice não seja negativo
        return attempts.subList(last10, size); 
    }



    /**
     * Returns a textual representation of the game state.
     *
     * @return A string representation of the current game state.
     */
    @Override
    public String toString() {
    	
        StringBuilder sb = new StringBuilder();
        
        String EOL = System.lineSeparator();

        // Current Score e Number of Trials
        sb.append("Number of Trials = " + numberOfTrials + EOL);
        sb.append("Score = " + currentScore + EOL);
        

        if (wasSecretRevealed()) {
            sb.append(secretCode.toString() + EOL);

        } else {
            sb.append("[");
            for (int i = 0; i < secretCode.getLength(); i++) {
                sb.append("?");
                if (i < secretCode.getLength() - 1) {
                    sb.append(", ");
                }
            }
            
            sb.append("]" + EOL);

        }
        if(attempts.size() == 0) {
            sb.append(EOL);         	
        }else {      	
            sb.append("\n");    	
        }

        // Obtém as últimas 10 tentativas (considerando o novo formato de attempts)
        List<Object[]> last10Attempts = getLast10Attempts(attempts); // Agora isso retorna Object[]

        // Iterando sobre as últimas 10 tentativas
        for (int i = 0; i < last10Attempts.size(); i++) {
            Object[] attempt = last10Attempts.get(i); // Cada item é um array de Object[]: [Code, int[]]
            Code code = (Code) attempt[0];  // Extraímos o Code
            int[] result = (int[]) attempt[1];  // Extraímos o array de resultados [A, B]

            sb.append("[");

            // Obtém e exibe as cores do código da tentativa
            List<Colour> attemptCode = code.getCode(); // Assumindo que Code tem um método getCode() que retorna uma lista de cores
            for (int j = 0; j < attemptCode.size(); j++) {
                sb.append(attemptCode.get(j)); // Imprime a cor da tentativa
                if (j < attemptCode.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]    " + result[0] + " " + result[1]);  // Exibe A e B
            sb.append(EOL);
        }
        

        return sb.toString();
    }

}

