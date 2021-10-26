package Game;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Board.*;
import Message.*;
import Score.*;


public class GameHandler{
    Player p = new Player(0, null, false, null, null, null);
    Message m = new Message();
    CalcScore cs = new CalcScore();
    CheckWord cw = new CheckWord();
    PlaceLetter pl = new PlaceLetter(); 
    


    public void game(int startPlayer) throws Exception {
            Player currentPicker = p.players.get(startPlayer);
            int rounds = currentPicker.board.length * currentPicker.board[0].length;
            for(int i=0; i<rounds; i++) {
                p.players.forEach((player) -> m.sendMessage(player.toString() + "\nWaiting for a letter to be picked...\n"));            
                String letter = pl.pickLetter().toUpperCase();

                ExecutorService threadpool = Executors.newFixedThreadPool(p.players.size());  
                for(Player player : p.players) {
                    
                        //Make sure every player can place their letter at the same time
                        Runnable task = new Runnable() {
                            @Override
                            public void run() {
                            pl.placeLetter(letter);   
                            }
                        };
                        threadpool.execute(task);
                    
                }
                threadpool.shutdown();

                //wait for all the answers to come in
                while(!threadpool.isTerminated()) {
                    Thread.sleep(100);
                }
                int nextPlayer = (currentPicker.playerID+1==p.players.size()?0:currentPicker.playerID+1);
                currentPicker = p.players.get(nextPlayer);
            }
            p.players.forEach((player) -> m.sendMessage(player.toString() + "\n"));
            p.players.forEach((player) -> player.words=cw.checkWords(player.board));
            p.players.forEach((player) -> player.score=cs.calculateScore(player.words));
            Collections.sort(p.players);
            String winnerMsg = "Winner: PlayerID "+ p.players.get(0).playerID+ ", Scores:\n";
            for(Player player : p.players) {winnerMsg += "PlayerID " + player.playerID + " Score " + player.score + "\n";}
            for(Player player : p.players) {m.sendMessage(winnerMsg);}
            System.exit(0); //quit game
        }
    }
