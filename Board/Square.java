package Board;

import java.util.Arrays;
import java.util.HashMap;
import Game.*;
public class Square {
    //Square types
    public static final int RL = 1; //regular letter
    public static final int DL = 2; //double letter
    public static final int TL = 3; //tripple letter
    public static final int DW = 4; //double word
    public static final int TW = 5; //tripple word
    
    public static final String LETTER_VALUES = "1 point:  E A I O N R T L S U, 2 points: D G, 3 points B C M P\n" + 
                                               "4 points: F H V W Y, 5 points: K, 8 points: J X, 10 points Q Z";

    public String letter = ""; //empty until 
    public int squareType = RL;
    public int letterValue = 0; //value depends on game-mode
    public boolean scrabbleValues = false;
    public HashMap<String, Integer> englishScrabbleTiles;
    Square[][] board;

    public void createBoard(int gameMode, int row, int col){
        
        Square board[][] = new Square[row][col];
        for(Square [] tiles: board) {Arrays.fill(tiles, new Square(gameMode));}
        gameSetup(numberOfPlayers, numberOfBots, board);

    }

    public Square(boolean scrabbleValues) { //regular mode constructor
        this(scrabbleValues, RL);
    }
    public Square(boolean scrabbleValues, int squareType) {
        this.scrabbleValues = scrabbleValues;
        this.squareType = squareType;    
    }
    
    public void put(String letter) {
        this.letter = letter;
        this.letterValue = 1;
        if(scrabbleValues) {
            this.letterValue = englishScrabbleTiles.get(letter);
        }
    }
    
    public Square(String letter, int squareType, int letterValue) { //scrabble mode constructor
        this.letter = letter;
        this.squareType = squareType;
        this.letterValue = letterValue;
    }
    
    @Override
    public String toString() {
        return this.letter;
    }
}