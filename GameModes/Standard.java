package GameModes;

import java.util.Arrays;

import Board.*;
public class Standard extends GameMode{

    public Standard(int numPlayers, int numBots, Square[][] board){
        setName("Play standard WordSquares id 1");
        setID(1);
        for(Square [] tiles: board) {Arrays.fill(tiles, new Square(true));}
        StartGame(numPlayers, numBots, board);
    }
   
}
