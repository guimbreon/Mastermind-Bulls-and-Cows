package types;


//Documentation needed.
/*
 * NÃO IMPLEMENTAR OS METODOS DA INTERFACE
 * 
 * APENAS IMPLEMENTAR NO ASBTRACTMASTERMINDGAME
 * 
 * 
 * NÃO DUVIDAR 
 * 
 * */

public interface MastermingGame {
	
	public static final int MAX_TRIALS = 100;
	
	public void play(Code trial);
	
	public boolean isRoundFinished();

	public void startNewRound();
	
	public Code bestTrial();
	
	public Colour hint();

	public int getNumberOfTrials();
	
	public int score();
	
	public boolean wasSecretRevealed();

}
