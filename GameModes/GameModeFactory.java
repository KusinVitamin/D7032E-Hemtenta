package GameModes;
import Board.*;
import Game.GameSetup;

public class GameModeFactory {
    GameMode gm = new GameMode();

    public void makeGameMode(int gameMode, int numPlayers, int numBots, Square[][] board, boolean random){
        GameMode selection = null;
        

        switch (gameMode) {
            case 1:
                
                gm.Standard(numPlayers, numBots, board);
             
            case 2: 

                Scrabble(numPlayers,numBots, board, random);
            default:
                break;
        }
        
    }

    
}
