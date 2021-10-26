package Score;

import java.util.ArrayList;
import java.util.Arrays;

import Board.*;
import GameModes.*;
import Game.*;
public class CalcScore implements Comparable{
    public int score=0;
    GameSettings g = new GameSettings();
    Player p = new Player(0, null, false, null, null, null);

    
        public int calculateScore(ArrayList<Square[]> words) {
                int score = 0;
                if(g.gameMode == 1) { //regular WordSquares scoring
                    for(Square[] word : words) { //score: 1, 2, 4, 6, 8, 10, etc.
                        if(word.length==3) score+=1;
                        if(word.length>3) score+=(word.length-3)*2;
                    }
                } else {
                    for(Square[] word : words) {
                        int wordScore = 0;
                        int wordMultiplier = 1;
                        for(int i=0;i<word.length; i++) {
                            int letterMultiplier = 1;
                            if(word[i].squareType == Square.DL) {letterMultiplier = 2;}
                            if(word[i].squareType == Square.TL) {letterMultiplier = 3;}
                            wordScore += (word[i].letterValue * letterMultiplier);
                            int tileMultiplier = 1;
                            if(word[i].squareType == Square.DW) {tileMultiplier = 2;}
                            if(word[i].squareType == Square.TW) {tileMultiplier = 3;}
                            wordMultiplier = wordMultiplier * tileMultiplier;
                        }
                        wordScore = wordScore * wordMultiplier;
                        String theWord = Arrays.toString(word).replace("[", "").replace("]", "").replace(", ", "");
            //                System.out.println("Word: " + theWord + ", Score: " + wordScore);
                        score += wordScore;
                    }            
                }
                return score;
            }


            public int compareTo(Player o) {
                //Reverse order: Highest score first
                return o.score - this.score;
            }


            @Override
            public int compareTo(Object o) {
                // TODO fråga om det här
                return 0;
            }        
            
}    