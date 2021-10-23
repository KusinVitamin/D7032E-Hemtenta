package Board;



 //Print the board
 @Override
 public String toString() {
     int asciiRowCount = 97; //a
     String retStr = "";
     for(int i=0; i<board[0].length; i++) {
         retStr += "\t"+RESET+HEADING+"  "+i+"  ";
     }
     for(Square[] cols : board) {
         retStr += "\t" + RESET +"\n"+HEADING + "  "+ ((char) asciiRowCount++)+"  "; 
         for(Square letter : cols) {
             String coloring = "";
             if(letter.squareType == Square.RL) {coloring = REGULAR;}
             if(letter.squareType == Square.DL) {coloring = DOUBLE_LETTER;}
             if(letter.squareType == Square.TL) {coloring = TRIPPLE_LETTER;}
             if(letter.squareType == Square.DW) {coloring = DOUBLE_WORD;}
             if(letter.squareType == Square.TW) {coloring = TRIPPLE_WORD;}
             String letterValue = (letter.letterValue == 0)?"     ":" ["+letter.letterValue+"]";
             String theLetter = "";
             if(letter.scrabbleValues) {
                 theLetter = letter.letter+letterValue;
             } else {
                 theLetter = "  "+(letter.letter.equals("")?" ":letter.letter)+"  ";
             }
             retStr += "\t" + RESET + coloring + theLetter;
         }
     }
     retStr += "\t";
     if(scrabbleMode) {
         retStr += RESET + "\n\n\t" +REGULAR + " STD \t" + RESET+DOUBLE_LETTER + " DL  \t" + RESET+TRIPPLE_LETTER + " TL  \t" + RESET+DOUBLE_WORD + " DW  \t" + RESET+TRIPPLE_WORD + " TW  \t" + RESET;
     }
     return retStr + RESET + "\n";
 }