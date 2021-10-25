package Score;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

import Dictionary.*;
import Board.*;
public class CheckWord{
    GetDictionary d = new GetDictionary();

        public ArrayList<Square[]> checkWords(Square[][] board) {
            ArrayList<Square[]> words = new ArrayList();
            //Check all possible combinations for each row
            for(Square[] columns : board) {
                for(int col=0; col<columns.length; col++) {
                    ArrayList<Square> possibleWord = new ArrayList();
                    //String possibleWord = "";
                    for(int i=col; i<columns.length; i++) {
                        possibleWord.add(columns[i]);
                        String aWord = Arrays.toString(possibleWord.toArray()).replace("[", "").replace("]", "").replace(", ", "");
                        if(d.dictionary.contains(aWord)){
                            words.add(possibleWord.toArray(new Square[possibleWord.size()]));
                        }
                    }
                }
            }
            //Check all possible combinations for each column
            for(int col = 0; col<board[0].length; col++) {
                Square[] rows = new Square[board.length];
                for(int row=0; row<rows.length; row++) {
                    rows[row] = board[row][col];
                }
                for(int row=0; row<rows.length; row++) {
                    ArrayList<Square> possibleWord = new ArrayList();
                    for(int i=row; i<rows.length; i++) {
                        possibleWord.add(rows[i]);
                        String aWord = Arrays.toString(possibleWord.toArray()).replace("[", "").replace("]", "").replace(", ", "");
                        if(d.dictionary.contains(aWord)){
                            words.add(possibleWord.toArray(new Square[possibleWord.size()]));
                        }                                    
                    }
                }
            }
            //Check downwards diagonals from left to right
            for(int col=0; col<board[0].length; col++) {
                for(int row=board.length-1; row>=0; row--) { //start bottom-left
                    ArrayList<Square> possibleWord = new ArrayList();
                    int r=row, c=col;
                    while(r<board.length && c<board[0].length) {
                        possibleWord.add(board[r][c]);
                        String aWord = Arrays.toString(possibleWord.toArray()).replace("[", "").replace("]", "").replace(", ", "");
                        if(d.dictionary.contains(aWord)) {
                            words.add(possibleWord.toArray(new Square[possibleWord.size()]));
                        }
                        r++; c++;
                    }
                }
            }
            return words;
        }
    }