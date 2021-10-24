package Board;
import java.util.Random;
import Board.*;
import Message.*;
import Score.*;



public class placeLetter(String letter) {
   // int value = (scrabbleMode?englishScrabbleTiles.get(letter):1);
    String theLetter = letter + (scrabbleMode?" [" + value + "]":"");
    int r, c =0;         
    if(!isBot) {
        sendMessage("Place " + theLetter + " (syntax [row column])");
        do {
            String place = readMessage().toLowerCase();
            String[] placement = (place.contains(" ")?place.split(" "):place.split("")); //got tired of writing spaces when picking a letter
            r = ((int) placement[0].charAt(0))-97; //ascii code for a
            c = Integer.parseInt(placement[1]);
        } while(!board[r][c].letter.equals(""));
    } else { //bot
        Random rnd = new Random();
        do {
            r = rnd.nextInt(board.length);
            rnd = new Random();
            c = rnd.nextInt(board[0].length);
        } while(!board[r][c].letter.equals(""));
    }
    board[r][c].letter = letter;
    board[r][c].letterValue = value;    
}

public void placeLetter(String letter, String place) {//used for testing only - remove later
    if(isBot){this.placeLetter(letter);}
    else {
        String[] placement = place.split("");
        int r = ((int) placement[0].charAt(0))-97;
        int c = Integer.parseInt(placement[1]);
        board[r][c].letter = letter;
        board[r][c].letterValue = (scrabbleMode?englishScrabbleTiles.get(letter):1);
    }
}

public String pickLetter() {
    if(isBot) {
        Random rnd = new Random();
        int theLetter = rnd.nextInt(26);
        return ""+((char) (theLetter+65));
    }
    sendMessage((scrabbleMode?Square.LETTER_VALUES+"\n":"") + "Pick a letter");
    return readMessage();
}
