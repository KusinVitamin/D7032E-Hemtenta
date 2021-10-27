package GameModes;
import Board.*;
public class Scrabble extends GameMode{

    public Scrabble(int numPlayers, int numBots, Square[][] board, boolean random){
        setID(2);
        if(random = false){
            setName("Load 5x5 predefined ScrabbleBoard and play ScrabbleSquares id 3");
        }else{
            setName("Load 5x5 randomised ScrabbleBoard and play ScrabbleSquares id 4");
        }

    }

}