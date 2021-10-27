import java.io.File;

public class menutest {
    File folder = new File("C:/Desktop/D7032E Hemtenta/GameModes");
    String language="English";
    public int rows=3; 
    public int columns=3; 
    public int numberOfPlayers=1; 
    public int numberOfBots=1;
    String playmode = "";
    public int gameMode = 0;
    String modes = null;

    public void main(String[] args) {
        System.out.println( "****************************************************************\n" +
                            " Welcome to VarietyBoggle\n" +
                            "****************************************************************\n" +
                            " Current settings:\n" +
                            "    Board size (rows/columns): " + rows + "/" + columns + "\n" +
                            "    Language: "+ language + "\n" + 
                            "    Number of players: " + numberOfPlayers + "\n"+
                            "    Number of bots: " + numberOfBots + "\n"+
                            "    Testing (remove for final release): " + "test" + "\n"+
                            "****************************************************************\n" +
                            " Menu:\n" +
                            while((line = bufferedReader.readLine()) != null) {
                                modes.add(line);
                            }
                            "  [1] Play standard WordSquares\n" +
                            "  [2] Play ScrabbleSquares on standard board\n" +
                            "  [3] Load 5x5 predefined ScrabbleBoard and play ScrabbleSquares\n" +
                            "  [4] Load 5x5 randomised ScrabbleBoard and play ScrabbleSquares\n" +
                            "  [5] Settings\n" +
                            "  [!] Quit\n" +
                            "****************************************************************\n"); 
                            
    }

}
