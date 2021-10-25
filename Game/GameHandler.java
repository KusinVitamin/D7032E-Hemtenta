package Game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Board.*;
import Message.*;
import Score.*;

public class GameHandler{
    Player p = new Player(0, null, false, null, null, null);
    Message m = new Message();
    


    public void game(int startPlayer) throws Exception {
            Player currentPicker = p.players.get(startPlayer);
            int rounds = currentPicker.board.length * currentPicker.board[0].length;
            for(int i=0; i<rounds; i++) {
                p.players.forEach((player) -> m.sendMessage(player.toString() + "\nWaiting for a letter to be picked...\n"));            
                String letter = test?test55[i][0]:currentPicker.pickLetter().toUpperCase(); //use predefined picks during test

                ExecutorService threadpool = Executors.newFixedThreadPool(p.players.size());  
                for(Player player : players) {
                    if(test) {player.placeLetter(letter, test55[i][1]);}
                    else {
                        //Make sure every player can place their letter at the same time
                        Runnable task = new Runnable() {
                            @Override
                            public void run() {
                            player.placeLetter(letter);   
                            }
                        };
                        threadpool.execute(task);
                    }
                }
                threadpool.shutdown();

                //wait for all the answers to come in
                while(!threadpool.isTerminated()) {
                    Thread.sleep(100);
                }
                int nextPlayer = (currentPicker.playerID+1==p.players.size()?0:currentPicker.playerID+1);
                currentPicker = players.get(nextPlayer);
            }
            p.players.forEach((player) -> player.sendMessage(player.toString() + "\n"));
            p.players.forEach((player) -> player.words=checkWords(player.board));
            p.players.forEach((player) -> player.score=calculateScore(player.words));
            Collections.sort(players);
            String winnerMsg = "Winner: PlayerID "+ p.players.get(0).playerID+ ", Scores:\n";
            for(Player player : p.players) {winnerMsg += "PlayerID " + player.playerID + " Score " + player.score + "\n";}
            for(Player player : p.players) {m.sendMessage(winnerMsg);}
            System.exit(0); //quit game
        }
    }