package Board;
import java.security.cert.PolicyQualifierInfo;
import java.util.Random;
import Board.*;
import Message.*;
import Score.*;
import Game.*;




public class PlaceLetter{
    Player p1 = new Player(0, null, false, null, null, null);
    GameHandler gh = new GameHandler();
    GameSettings gs = new GameSettings();
    TileValues tile = new TileValues();
    Message m = new Message();
      
    public void placeLetter(String letter) {
    

        int value = (gs.gameMode==2?tile.getDictValue(letter):1);
        String theLetter = letter + (gs.gameMode==2?" [" + value + "]":"");
        int row, col =0;
        
             
        if(!p1.isBot) {
            m.sendMessage("Place " + theLetter + " (syntax [row column])");
            do {
                String place = m.readMessage().toLowerCase();
                String[] placement = (place.contains(" ")?place.split(" "):place.split("")); //got tired of writing spaces when picking a letter
                row = ((int) placement[0].charAt(0))-97; //ascii code for a
                col = Integer.parseInt(placement[1]);
            } while(!p1.board[row][col].letter.equals(""));
        } else { //bot
            Random rnd = new Random();
            do {
                row = rnd.nextInt(p1.board.length);
                rnd = new Random();
                col = rnd.nextInt(p1.board[0].length);
            } while(!p1.board[row][col].letter.equals(""));
        }
        p1.board[row][col].letter = letter;
        p1.board[row][col].letterValue = value;    
    }

    public void placeLetter(String letter, String place) {//used for testing only - remove later
        if(p1.isBot){this.placeLetter(letter);}
        else {
            String[] placement = place.split("");
            int r = ((int) placement[0].charAt(0))-97;
            int c = Integer.parseInt(placement[1]);
            p1.board[r][c].letter = letter;
            p1.board[r][c].letterValue = (gs.gameMode==2?tile.getDictValue(letter):1);
        }
    }

    public String pickLetter() {
        if(p1.isBot) {
            Random rnd = new Random();
            int theLetter = rnd.nextInt(26);
            return ""+((char) (theLetter+65));
        }
        m.sendMessage((gs.gameMode==2?Square.LETTER_VALUES+"\n":"") + "Pick a letter");
        return m.readMessage();
    }

}