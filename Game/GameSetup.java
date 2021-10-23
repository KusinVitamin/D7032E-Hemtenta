package Game;

public void gameSetup(int numPlayers, int numBots, Square[][] board) {
    try {
        FileReader fileReader = new FileReader("CollinsScrabbleWords2019.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while((line = bufferedReader.readLine()) != null) {
            dictionary.add(line);
        }
        initScrabbleValues();
        bufferedReader.close();
        server(numPlayers, numBots, board);
        Random rnd = new Random();
        int randomStarter = rnd.nextInt(players.size());
        game(randomStarter);
    } catch(Exception e) {
        System.out.println(e.getMessage());
    }
}
