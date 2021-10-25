package Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import Score.*;



public class GetDictionary {
    public ArrayList<String> dictionary = new ArrayList<String>();
    TileValues t = new TileValues();


    public void dictionary(String language){
        try {
            FileReader fileReader = new FileReader("CollinsScrabbleWords2019.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                dictionary.add(line);
            }
            t.setTiles();
            bufferedReader.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}
