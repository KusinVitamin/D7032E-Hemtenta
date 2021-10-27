package GameModes;
import java.util.Arrays;
import java.util.Random;

import Board.*;
import Game.GameSetup;

public class GameMode {
    private String name;
    private int id;
    GameSetup g = new GameSetup();
    Square b = new Square();

    public void Standard(int numPlayers, int numBots, Square[][] board){        
        for(Square[] row: board) {
            Arrays.fill(row, Square.RL);}
            StartGame(numPlayers, numBots, board);
    }

    public void Scrabble(int numPlayers, int numBots, boolean random){
          int [][] board =   {{Square.DW, Square.RL, Square.TW, Square.RL, Square.DW},
                             {Square.RL, Square.DL, Square.RL, Square.DL, Square.RL},
                             {Square.TL, Square.RL, Square.TW, Square.RL, Square.TL},
                             {Square.RL, Square.DL, Square.RL, Square.DL, Square.RL},
                             {Square.DW, Square.RL, Square.TW, Square.RL, Square.DW}};
            
        if(random = true){
            for(int[] row: board) {Arrays.fill(row, Square.RL);}
            int tileTypes [] = {Square.DL, Square.DL, Square.DL, Square.TL, Square.TL, Square.DW, Square.DW, Square.DW, Square.TW};
            for(int tile : tileTypes) {
                Random rnd = new Random();
                int r, c;
                do {r = rnd.nextInt(5); c = rnd.nextInt(5);
                } while(board[r][c]!=Square.RL);
                board[r][c] = tile;
            }

        }

    }
    
    public void ScrabbleSquares(int numPlayers, int numBots, Square[][] board){
        
    }


    public void StartGame(int numPlayers, int numBots, Square[][] board){
        g.gameSetup(numPlayers, numBots, board);
        


    }
    
}
