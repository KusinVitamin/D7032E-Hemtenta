package Game;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import Board.*;


public class Player implements Comparable<Player>{
    public int playerID;
    public boolean online;
    public boolean isBot;
    public Socket connection;
    public ObjectInputStream inFromClient;
    public ObjectOutputStream outToClient;
    public ArrayList<Square[]> words;
    Scanner in = new Scanner(System.in);
    public Square[][] board;
    public int score=0;


    public Square[][] getBoard() {
        return this.board;
        
    }

    public Player(int playerID, Square[][] board, boolean isBot, Socket connection, ObjectInputStream inFromClient, ObjectOutputStream outToClient) {
        this.playerID = playerID;
        Square[][] newBoard = new Square[board.length][board[0].length]; //Make a new instance and copy - avoid writing to the same board
        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[r].length; c++) {
                newBoard[r][c] = new Square(board[r][c].scrabbleValues, board[r][c].squareType);
            }
        } //copy
        this.board = newBoard;
        if(connection==null)
            this.online = false;
        else
            this.online = true;
        this.connection = connection; this.inFromClient = inFromClient; this.outToClient = outToClient; this.isBot = isBot;        
    }
    @Override
    public int compareTo(Player o) {
        // TODO Auto-generated method stub
        return 0;
    }
            

    public static void main(String argv[]) {
        GameSettings game = new GameSettings();
        game.menu (argv);
    }
}