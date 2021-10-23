public void server(int numberPlayers, int numberOfBots, Square[][] board) throws Exception {
    // Square[][] copy = Arrays.stream(board).map(Square[]::clone).toArray(Square[][]::new); //creates a new instance of board with copied values
    players.add(new Player(0, board, false, null, null, null)); //add this instance as a player
    //Open for connections if there are online players
    for(int i=0; i<numberOfBots; i++) {
        players.add(new Player(i+1, board, true, null, null, null)); //add a bot    
    }
    if(numberPlayers>1)
        aSocket = new ServerSocket(2048);
    for(int i=numberOfBots+1; i<numberPlayers+numberOfBots; i++) {
        Socket connectionSocket = aSocket.accept();
        ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
        ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
        players.add(new Player(i, board, false, connectionSocket, inFromClient, outToClient)); //add an online client
        System.out.println("Connected to player " + i);
        outToClient.writeObject("You connected to the server as player " + i + "\n");
    }
    
}