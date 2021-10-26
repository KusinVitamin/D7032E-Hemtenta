package Message;

import Connection.*;
import Game.*;

public class Message{
    Player p = new Player(0, null, false, null, null, null);

    public String readMessage() {
        String word = ""; 
        if(p.online)
            try{word = (String) p.inFromClient.readObject();} catch (Exception e){}
        else
            try {word=p.in.nextLine();} catch(Exception e){}
        return word;
    } 

    public void sendMessage(Object message) {
        if(p.online) {
            try {p.outToClient.writeObject(message);} catch (Exception e) {}
        } else if(!p.isBot){
            System.out.println(message);                
        }
    }
}