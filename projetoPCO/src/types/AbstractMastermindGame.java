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
    protected Code secretCode;
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
        startNewRound();
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
    	numberOfTrials += 1;
        if(!wasSecretRevealed()) {
        	addTrial(x);
         }
        
        if(x.equals(secretCode) && !wasSecretRevealed()) {
        	secretRevealed = true;
            updateScore();
        }
        
    }
    /*-----EXTRA-----
     * adiciona sem repetir as tentativas
     * 
     * ver se for usar em outras funções fora do AbstractMastermindGame
     * tenho q colocar "protected" e nao private
     * 
     *      
     * AINDA TENHO Q POR O RESULTADO
     * TENS QUE RETIRAR A TENTATIVA QUE FOI REPETIDA E PO-LA NO FINAL
     * 
     * */
    
    private void addTrial(Code x) {
    	if (!attempts.contains(x)) {
	        int[] result = secretCode.howManyCorrect(x); // Get correctness
	        Object[] trial = {x, result}; // Create an Object[] to store Code and correctness
	        attempts.add(trial); // Add it to the list
    	}
    }

    
    /*-----EXTRA-----
     * 
     * gera o codigo secreto
     * 
     * 
     * ver se for usar em outras funções fora do AbstractMastermindGame
     * tenho q colocar "protected" e nao private
     * 
     * 
     * */
    private void genSecretCode() {
        List<Colour> secretCodeList = new ArrayList<>();
		int randomIndex;
    	for(int i = 0; i < size; i++) {
    		randomIndex = random.nextInt(colours.length);
    		secretCodeList.add(colours[randomIndex]);
    	}
    	secretCode = new Code(secretCodeList);    	
    }
    
    // Method to start a new round of the game
    //which is genSecretCode and reset the numberOfTrials
    @Override
    public void startNewRound() {
    	genSecretCode();
    	this.numberOfTrials = 0;
    	this.secretRevealed = false;
    }

    // Method to get the best trial (highest score in terms of A and B values)
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
        	//System.out.println(attempt[0] + " ");
        	Code codigo = (Code) attempt[0];
        	System.out.println(codigo.toString() + ": a_" + resultados[0] + "  b_" + resultados[1]);
        	
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
        
        System.out.println("Secret Code:" + secretCode);


        return bestTrial; // Retorna o melhor teste encontrado
    }



    // Method to provide a colour hint for the player
    @Override
    public Colour hint() {
        int randomIndex;
        randomIndex = random.nextInt(secretCode.getLength());
        return secretCode.getCode().get(randomIndex);
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
    
    public static List<Object[]> getLast10Attempts(List<Object[]> attempts) {
        int size = attempts.size();
        int last10 = Math.max(size - 10, 0);  // Garante que o índice não seja negativo
        return attempts.subList(last10, size); 
    }



    // Method to return a textual representation of the game state
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        // Current Score e Number of Trials
        sb.append("Number of Trials = " + numberOfTrials + "\n");
        sb.append("Score = " + currentScore + "\n");
        

        if (wasSecretRevealed()) {
            sb.append(secretCode.toString() + "\n");
        } else {
            sb.append("[");
            for (int i = 0; i < secretCode.getLength(); i++) {
                sb.append("?");
                if (i < secretCode.getLength() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]\n");
        }
        sb.append("\n");

        // Obtém as últimas 10 tentativas (considerando o novo formato de attempts)
        List<Object[]> last10Attempts = getLast10Attempts(attempts); // Agora isso retorna Object[]
        int startingIndex = Math.max(attempts.size() - 10, 0); // Calcula o índice real da primeira tentativa exibida

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
            sb.append("]    " + result[0] + " " + result[1] + " \n");  // Exibe A e B
        }


        return sb.toString();
    }

}

