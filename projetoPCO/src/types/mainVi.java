package types;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import games.MultiColourMastermindGame;

public  class mainVi {
	
	
	public static void main (String[] args) {
		
		ArrayList<MultiColour> attempt1 = new ArrayList<>();
        attempt1.add(MultiColour.BLUE);
        attempt1.add(MultiColour.RED);
        attempt1.add(MultiColour.BLUE);
        attempt1.add(MultiColour.GREEN);
        attempt1.add(MultiColour.BLUE);
        
        Code code1 = new Code(attempt1);
        
        ArrayList<MultiColour> attempt2 = new ArrayList<>();
        attempt2.add(MultiColour.RED);
        attempt2.add(MultiColour.YELLOW);
        attempt2.add(MultiColour.GREEN);
        attempt2.add(MultiColour.BLUE);
        attempt2.add(MultiColour.PINK);
        Code code2 = new Code(attempt2);

        ArrayList<MultiColour> attempt3 = new ArrayList<>();
        attempt3.add(MultiColour.PINK);
        attempt3.add(MultiColour.ORANGE);
        attempt3.add(MultiColour.BLUE);
        attempt3.add(MultiColour.RED);
        attempt3.add(MultiColour.YELLOW);
        Code code3 = new Code(attempt3);
        
        ArrayList<MultiColour> attempt4 = new ArrayList<>();
        attempt4.add(MultiColour.GREEN);
        attempt4.add(MultiColour.BLUE);
        attempt4.add(MultiColour.YELLOW);
        attempt4.add(MultiColour.PINK);
        attempt4.add(MultiColour.ORANGE);
        Code code4 = new Code(attempt4);

        ArrayList<MultiColour> attempt5 = new ArrayList<>();
        attempt5.add(MultiColour.RED);
        attempt5.add(MultiColour.PINK);
        attempt5.add(MultiColour.ORANGE);
        attempt5.add(MultiColour.YELLOW);
        attempt5.add(MultiColour.GREEN);
        Code code5 = new Code(attempt5);

        ArrayList<MultiColour> attempt6 = new ArrayList<>();
        attempt6.add(MultiColour.YELLOW);
        attempt6.add(MultiColour.ORANGE);
        attempt6.add(MultiColour.BLUE);
        attempt6.add(MultiColour.GREEN);
        attempt6.add(MultiColour.RED);
        Code code6 = new Code(attempt6);

//        ArrayList<MultiColour> attempt7 = new ArrayList<>();
//        attempt7.add(MultiColour.PINK);
//        attempt7.add(MultiColour.BLUE);
//        attempt7.add(MultiColour.RED);
//        attempt7.add(MultiColour.GREEN);
//        attempt7.add(MultiColour.YELLOW);
//        Code code7 = new Code(attempt7);

        ArrayList<MultiColour> attempt8 = new ArrayList<>();
        attempt8.add(MultiColour.BLUE);
        attempt8.add(MultiColour.GREEN);
        attempt8.add(MultiColour.PINK);
        attempt8.add(MultiColour.ORANGE);
        attempt8.add(MultiColour.YELLOW);
        Code code8 = new Code(attempt8);

        ArrayList<MultiColour> attempt9 = new ArrayList<>();
        attempt9.add(MultiColour.RED);
        attempt9.add(MultiColour.ORANGE);
        attempt9.add(MultiColour.YELLOW);
        attempt9.add(MultiColour.PINK);
        attempt9.add(MultiColour.BLUE);
        Code code9 = new Code(attempt9);

        ArrayList<MultiColour> attempt10 = new ArrayList<>();
        attempt10.add(MultiColour.GREEN);
        attempt10.add(MultiColour.RED);
        attempt10.add(MultiColour.ORANGE);
        attempt10.add(MultiColour.PINK);
        attempt10.add(MultiColour.YELLOW);
        Code code10 = new Code(attempt10);

        ArrayList<MultiColour> attempt11 = new ArrayList<>();
        attempt11.add(MultiColour.YELLOW);
        attempt11.add(MultiColour.BLUE);
        attempt11.add(MultiColour.GREEN);
        attempt11.add(MultiColour.RED);
        attempt11.add(MultiColour.PINK);
        Code code11 = new Code(attempt11);

        ArrayList<MultiColour> attempt12 = new ArrayList<>();
        attempt12.add(MultiColour.ORANGE);
        attempt12.add(MultiColour.PINK);
        attempt12.add(MultiColour.YELLOW);
        attempt12.add(MultiColour.GREEN);
        attempt12.add(MultiColour.RED);
        Code code12 = new Code(attempt12);

        ArrayList<MultiColour> attempt13 = new ArrayList<>();
        attempt13.add(MultiColour.BLUE);
        attempt13.add(MultiColour.RED);
        attempt13.add(MultiColour.PINK);
        attempt13.add(MultiColour.ORANGE);
        attempt13.add(MultiColour.YELLOW);
        Code code13 = new Code(attempt13);
        
        ArrayList<MultiColour> attempt14 = new ArrayList<>();
        attempt14.add(MultiColour.GREEN);
        attempt14.add(MultiColour.PINK);
        attempt14.add(MultiColour.RED);
        attempt14.add(MultiColour.GREEN);
        attempt14.add(MultiColour.YELLOW);
        Code code14 = new Code(attempt14);
        
        MultiColourMastermindGame newjogo = new MultiColourMastermindGame(1, 5, MultiColour.values());
        
        
        newjogo.startNewRound();
        newjogo.play(code1);
        newjogo.play(code2);
        newjogo.play(code3);
        newjogo.play(code4);
        newjogo.play(code5);
        newjogo.play(code6);
   //     newjogo.play(code7);
        newjogo.play(code8);
        newjogo.play(code9);
        newjogo.play(code10);
        newjogo.play(code11);
        newjogo.play(code12);
        newjogo.play(code13);
        newjogo.play(code14);
        
        
       // newjogo.bestTrial();
       System.out.print(newjogo.bestTrial());
  //     System.out.print(newjogo.toString());
        
	}

}
