package Board;
import java.security.cert.PolicyQualifierInfo;
import java.util.Random;
import Board.*;
import Message.*;
import Score.*;
import Game.*;




public class PlaceLetter extends TestPlayer{
    Player p1 = new Player();
    TestPlayer tp = new TestPlayer();
    GameHandler gh = new GameHandler();
    GameSettings gs = new GameSettings();
    TileValues tile = new TileValues();
    Message m = new Message();
      
    public void placeLetter(String letter) {
    

        int value = (gs.scrabbleMode?tile.getDictValue(letter):1);
        String theLetter = letter + (gs.scrabbleMode?" [" + value + "]":"");
        int row, col =0;
        
             
        if(!tp.isBot) {
            m.sendMessage("Place " + theLetter + " (syntax [row column])");
            do {
                String place = m.readMessage().toLowerCase();
                String[] placement = (place.contains(" ")?place.split(" "):place.split("")); //got tired of writing spaces when picking a letter
                row = ((int) placement[0].charAt(0))-97; //ascii code for a
                col = Integer.parseInt(placement[1]);
            } while(!tp.board[row][col].letter.equals(""));
        } else { //bot
            Random rnd = new Random();
            do {
                row = rnd.nextInt(board.length);
                rnd = new Random();
                col = rnd.nextInt(tp.board[0].length);
            } while(!p.board[row][col].letter.equals(""));
        }
        tp.board[row][col].letter = letter;
        tp.board[row][col].letterValue = value;    
    }

    public void placeLetter(String letter, String place) {//used for testing only - remove later
        if(tp.isBot){this.placeLetter(letter);}
        else {
            String[] placement = place.split("");
            int r = ((int) placement[0].charAt(0))-97;
            int c = Integer.parseInt(placement[1]);
            tp.board[r][c].letter = letter;
            tp.board[r][c].letterValue = (gs.scrabbleMode?tile.getDictValue(letter):1);
        }
    }

    public String pickLetter() {
        if(tp.isBot) {
            Random rnd = new Random();
            int theLetter = rnd.nextInt(26);
            return ""+((char) (theLetter+65));
        }
        m.sendMessage((gs.scrabbleMode?Square.LETTER_VALUES+"\n":"") + "Pick a letter");
        return m.readMessage();
    }

}