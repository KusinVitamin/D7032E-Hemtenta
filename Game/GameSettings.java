package Game;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import Board.*;
import Connection.*;

public class GameSettings {
    String language="English";
    public int rows=3; 
    public int columns=3; 
    public int numberOfPlayers=1; 
    public int numberOfBots=1;
    String playmode = "";
    public int gameMode = 0;
    Square[][] Board;
    Client c = new Client();

    public void menu(String []params){

        if(params.length == 0) {
        while(!playmode.equals("!")) {
            System.out.println( "****************************************************************\n" +
                                " Welcome to VarietyBoggle\n" +
                                "****************************************************************\n" +
                                " Current settings:\n" +
                                "    Board size (rows/columns): " + rows + "/" + columns + "\n" +
                                "    Language: "+ language + "\n" + 
                                "    Number of players: " + numberOfPlayers + "\n"+
                                "    Number of bots: " + numberOfBots + "\n"+
                                "    Testing (remove for final release): " + "test" + "\n"+
                                "****************************************************************\n" +
                                " Menu:\n" +
                                "  [1] Play standard WordSquares\n" +
                                "  [2] Play ScrabbleSquares on standard board\n" +
                                "  [3] Load 5x5 predefined ScrabbleBoard and play ScrabbleSquares\n" +
                                "  [4] Load 5x5 randomised ScrabbleBoard and play ScrabbleSquares\n" +
                                "  [5] Settings\n" +
                                "  [!] Quit\n" +
                                "****************************************************************\n");            
            Scanner in = new Scanner(System.in);
            playmode = in.nextLine();
            if(playmode.equals("1") || playmode.equals("2")) {
                gameMode = 1;  
                Square b = new Square(true);
                b.createBoard(gameMode, rows, columns);           
            } else if(playmode.equals("3") ||playmode.equals("4")) {
                gameMode = 2;
                //5x5 predefined scrabbleboard
                int scrabbleBoard[][] = {{Square.DW, Square.RL, Square.TW, Square.RL, Square.DW},
                                         {Square.RL, Square.DL, Square.RL, Square.DL, Square.RL},
                                         {Square.TL, Square.RL, Square.TW, Square.RL, Square.TL},
                                         {Square.RL, Square.DL, Square.RL, Square.DL, Square.RL},
                                         {Square.DW, Square.RL, Square.TW, Square.RL, Square.DW}};
                if(playmode.equals("4")) {
                    //5x5 random scrabbleboard (3 double letter, 2 tripple letter, 3 double word, 1 tripple word)
                    for(int[] row: scrabbleBoard) {Arrays.fill(row, Square.RL);} //reset scrabbleBoard
                    //Random place 3 DL, 2 TL, 3 DW, 1 TW
                    int tileTypes [] = {Square.DL, Square.DL, Square.DL, Square.TL, Square.TL, Square.DW, Square.DW, Square.DW, Square.TW};
                    for(int tile : tileTypes) {
                        Random rnd = new Random();
                        int r, c;
                        do {r = rnd.nextInt(5); c = rnd.nextInt(5);
                        } while(scrabbleBoard[r][c]!=Square.RL);
                        scrabbleBoard[r][c] = tile;
                    }
                }
                //Create a board using the scrabbleBoard tiles
                Square board[][] = new Square[5][5];
                for(int i=0; i<5; i++) {
                    for(int j=0; j<5; j++) {
                        board[i][j] = new Square(true, scrabbleBoard[i][j]);
                    }    
                }
                GameSetup g = new GameSetup();
                g.gameSetup(numberOfPlayers, numberOfBots, board);                
            }
            else if(playmode.equals("5")) {
                //Settings
                System.out.println("****************************************************************\n" +
                                   " Current settings:\n" +
                                   "  [1]  Board size (rows/columns): " + rows + "/" + columns + "\n" +
                                   "  [2]  Language: "+ language + "\n" + 
                                   "  [3]  Number of players: " + numberOfPlayers + "\n"+
                                   "  [4]  Number of bots: " + numberOfBots + "\n"+
                                   "  [5]  Testing (remove for final release): " + "test" + "\n"+
                                   "  [6]  Return to the main menu" + "\n" +
                                   "****************************************************************\n");
                String setting = in.nextLine();
                if(setting.equals("1")) {
                    System.out.println("Enter new board size (rows/columns): ");
                    String[] option = in.nextLine().split("/");
                    rows = Integer.parseInt(option[0]);
                    columns = Integer.parseInt(option[1]);
                } else if(setting.equals("2")) {
                    System.out.println("Currently only English is supported");
                } else if(setting.equals("3")) {
                    System.out.println("Enter the number of players: ");
                    String option = in.nextLine();
                    numberOfPlayers = Integer.parseInt(option);
                } else if(setting.equals("4")) {
                    System.out.println("Enter the number of bots: ");
                    String option = in.nextLine();
                    numberOfBots = Integer.parseInt(option);
                } else if(setting.equals("5")) {
                    System.out.println("Toggling testing");
                 /*    test = !test;
                    if(test) {
                        rows=5; columns=5;
                    } */
                }
            }   
        }      
    } else {
        try {
            
            c.client("127.0.0.1");            
        } catch (Exception e){}
    }  
}
}