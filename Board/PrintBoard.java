package Board;
import java.util.Random;
import Game.*;



 //Print the board
 public class PrintBoard {
     Game.Player p = new Game.Player();
     Game.Player b = new Game.Player();

    public String DisplayBoard(){
     Square[][] board = p.getBoard();

        
     int asciiRowCount = 97; //a
     String retStr = "";
     for(int i=0; i<board[0].length; i++) {
         retStr += "\t"+Tiles.RESET+Tiles.HEADING+"  "+i+"  ";
     }
     for(Square[] cols : board) {
         retStr += "\t" + Tiles.RESET +"\n"+Tiles.HEADING + "  "+ ((char) asciiRowCount++)+"  "; 
         for(Square letter : cols) {
             String coloring = "";
             if(letter.squareType == Square.RL) {coloring = Tiles.REGULAR;}
             if(letter.squareType == Square.DL) {coloring = Tiles.DOUBLE_LETTER;}
             if(letter.squareType == Square.TL) {coloring = Tiles.TRIPPLE_LETTER;}
             if(letter.squareType == Square.DW) {coloring = Tiles.DOUBLE_WORD;}
             if(letter.squareType == Square.TW) {coloring = Tiles.TRIPPLE_WORD;}
             String letterValue = (letter.letterValue == 0)?"     ":" ["+letter.letterValue+"]";
             String theLetter = "";
             if(letter.scrabbleValues) {
                 theLetter = letter.letter+letterValue;
             } else {
                 theLetter = "  "+(letter.letter.equals("")?" ":letter.letter)+"  ";
             }
             retStr += "\t" + Tiles.RESET + coloring + theLetter;
         }
     }
     retStr += "\t";
     if(scrabbleMode) {
         retStr += Tiles.RESET + "\n\n\t" +Tiles.REGULAR + " STD \t" + Tiles.RESET+Tiles.DOUBLE_LETTER + " DL  \t" + Tiles.RESET+Tiles.TRIPPLE_LETTER + " TL  \t" + Tiles.RESET+Tiles.DOUBLE_WORD + " DW  \t" + RESET+TRIPPLE_WORD + " TW  \t" + RESET;
     }
     return retStr + Tiles.RESET + "\n";

    }

     public void placeLetter(String letter, int row, int col){
        // int value = (scrabbleMode?englishScrabbleTiles.get(letter):1);
       // String theLetter = letter + (scrabbleMode?" [" + value + "]":""); 
       int r = row ;
       int c = col;        
        if(!isBot) {
            sendMessage("Place " + letter + " (syntax [row column])");
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


    public String pickLetter() {
        if(b.isBot) {
            Random rnd = new Random();
            int theLetter = rnd.nextInt(26);
            return ""+((char) (theLetter+65));
        }
        sendMessage((scrabbleMode?Square.LETTER_VALUES+"\n":"") + "Pick a letter");
        return readMessage();
        }

 }
    
 

