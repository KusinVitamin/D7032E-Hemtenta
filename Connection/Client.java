package Connection;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client{

    public void client(String ipAddress) throws Exception {
        //Connect to server
        Socket aSocket = new Socket(ipAddress, 2048);
        ObjectOutputStream outToServer = new ObjectOutputStream(aSocket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(aSocket.getInputStream());
        //Get the hand of apples from server
        String nextMessage = "";
        while(!nextMessage.contains("Winner")){
            nextMessage = (String) inFromServer.readObject();
            System.out.println(nextMessage);
            if(nextMessage.contains("Pick") || nextMessage.contains("Place")) {
                Scanner in = new Scanner(System.in);
                outToServer.writeObject(in.nextLine());
            } 
        }
    }
}