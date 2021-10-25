package Game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import Board.*;
import Connection.*;
import Dictionary.GetDictionary;
import Game.*;
import Score.*;

public class GameSetup{
    Random rnd = new Random();
    int randomStarter = 0;
    Player p = new Player(randomStarter, null, false, null, null, null);
    Server s = new Server();
    GameHandler g = new GameHandler();
    GetDictionary d = new GetDictionary();
    TileValues t = new TileValues();



    public void gameSetup(int numPlayers, int numBots, Square[][] board) {
  
        try {
            d.dictionary("English");
            t.setTiles();
            s.server(numPlayers, numBots, board);
            Random rnd = new Random();
            randomStarter = rnd.nextInt(p.players.size());
            g.game(randomStarter);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}