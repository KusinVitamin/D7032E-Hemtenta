package Message;

import Connection.*;

public class Message{

    public String readMessage() {
        String word = ""; 
        if(online)
            try{word = (String) inFromClient.readObject();} catch (Exception e){}
        else
            try {word=in.nextLine();} catch(Exception e){}
        return word;
    } 

    public void sendMessage(Object message) {
        if(online) {
            try {outToClient.writeObject(message);} catch (Exception e) {}
        } else if(!isBot){
            System.out.println(message);                
        }
    }
}