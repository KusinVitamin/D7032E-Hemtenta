package Game;

public GameSettings(String[] params) {
    String language="English";
    int rows=3; int columns=3; int numberOfPlayers=1; int numberOfBots=1;
    String playmode = "";
    if(params.length == 0) {
        while(!playmode.equals("!")) {
            System.out.println( "****************************************************************\n" +
                                " Welcome to VarietyBoggle\n" +
                                "****************************************************************\n" +
                                " Current settings:\n" +
                                "    Board size (rows/columns): " + rows + "/" + columns + "\n" +
                                "    Language: "+ language + "\n" + 
                                "    Number of players: " + numberOfPlayers + "\n"+
                                "    Number of bots: " + numberOfBots + "\n"+
                                "    Testing (remove for final release): " + test + "\n"+
                                "****************************************************************\n" +
                                " Menu:\n" +
                                "  [1] Play standard WordSquares\n" +
                                "  [2] Play ScrabbleSquares on standard board\n" +
                                "  [3] Load 5x5 predefined ScrabbleBoard and play ScrabbleSquares\n" +
                                "  [4] Load 5x5 randomised ScrabbleBoard and play ScrabbleSquares\n" +
                                "  [5] Settings\n" +
                                "  [!] Quit\n" +
                                "****************************************************************\n");            
            Scanner in = new Scanner(System.in);
            playmode = in.nextLine();
            if(playmode.equals("1") || playmode.equals("2")) {
                scrabbleMode = playmode.equals("1")?false:true;
                Square board[][] = new Square[rows][columns];
                for(Square [] tiles: board) {Arrays.fill(tiles, new Square(scrabbleMode));}
                gameSetup(numberOfPlayers, numberOfBots, board);           
            } else if(playmode.equals("3") ||playmode.equals("4")) {
                scrabbleMode=true;
                //5x5 predefined scrabbleboard
                int scrabbleBoard[][] = {{VarietyWordSquares.Square.DW, VarietyWordSquares.Square.RL, VarietyWordSquares.Square.TW, VarietyWordSquares.Square.RL, VarietyWordSquares.Square.DW},
                                         {VarietyWordSquares.Square.RL, VarietyWordSquares.Square.DL, VarietyWordSquares.Square.RL, VarietyWordSquares.Square.DL, VarietyWordSquares.Square.RL},
                                         {VarietyWordSquares.Square.TL, VarietyWordSquares.Square.RL, VarietyWordSquares.Square.TW, VarietyWordSquares.Square.RL, VarietyWordSquares.Square.TL},
                                         {VarietyWordSquares.Square.RL, VarietyWordSquares.Square.DL, VarietyWordSquares.Square.RL, VarietyWordSquares.Square.DL, VarietyWordSquares.Square.RL},
                                         {VarietyWordSquares.Square.DW, VarietyWordSquares.Square.RL, VarietyWordSquares.Square.TW, VarietyWordSquares.Square.RL, VarietyWordSquares.Square.DW}};
                if(playmode.equals("4")) {
                    //5x5 random scrabbleboard (3 double letter, 2 tripple letter, 3 double word, 1 tripple word)
                    for(int[] row: scrabbleBoard) {Arrays.fill(row, VarietyWordSquares.Square.RL);} //reset scrabbleBoard
                    //Random place 3 DL, 2 TL, 3 DW, 1 TW
                    int tileTypes [] = {VarietyWordSquares.Square.DL, VarietyWordSquares.Square.DL, VarietyWordSquares.Square.DL, VarietyWordSquares.Square.TL, VarietyWordSquares.Square.TL, VarietyWordSquares.Square.DW, VarietyWordSquares.Square.DW, VarietyWordSquares.Square.DW, VarietyWordSquares.Square.TW};
                    for(int tile : tileTypes) {
                        Random rnd = new Random();
                        int r, c;
                        do {r = rnd.nextInt(5); c = rnd.nextInt(5);
                        } while(scrabbleBoard[r][c]!=VarietyWordSquares.Square.RL);
                        scrabbleBoard[r][c] = tile;
                    }
                }
                //Create a board using the scrabbleBoard tiles
                Square board[][] = new Square[5][5];
                for(int i=0; i<5; i++) {
                    for(int j=0; j<5; j++) {
                        board[i][j] = new Square(true, scrabbleBoard[i][j]);
                    }    
                }
                gameSetup(numberOfPlayers, numberOfBots, board);                
            }
            else if(playmode.equals("5")) {
                //Settings
                System.out.println("****************************************************************\n" +
                                   " Current settings:\n" +
                                   "  [1]  Board size (rows/columns): " + rows + "/" + columns + "\n" +
                                   "  [2]  Language: "+ language + "\n" + 
                                   "  [3]  Number of players: " + numberOfPlayers + "\n"+
                                   "  [4]  Number of bots: " + numberOfBots + "\n"+
                                   "  [5]  Testing (remove for final release): " + test + "\n"+
                                   "  [6]  Return to the main menu" + "\n" +
                                   "****************************************************************\n");
                String setting = in.nextLine();
                if(setting.equals("1")) {
                    System.out.println("Enter new board size (rows/columns): ");
                    String[] option = in.nextLine().split("/");
                    rows = Integer.parseInt(option[0]);
                    columns = Integer.parseInt(option[1]);
                } else if(setting.equals("2")) {
                    System.out.println("Currently only English is supported");
                } else if(setting.equals("3")) {
                    System.out.println("Enter the number of players: ");
                    String option = in.nextLine();
                    numberOfPlayers = Integer.parseInt(option);
                } else if(setting.equals("4")) {
                    System.out.println("Enter the number of bots: ");
                    String option = in.nextLine();
                    numberOfBots = Integer.parseInt(option);
                } else if(setting.equals("5")) {
                    System.out.println("Toggling testing");
                    test = !test;
                    if(test) {
                        rows=5; columns=5;
                    }
                }
            }   
        }      
    } else {
        try {
            client("127.0.0.1");            
        } catch (Exception e){}
    }  
}
