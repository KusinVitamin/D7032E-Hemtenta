package Message;

public void sendMessage(Object message) {
    if(online) {
        try {outToClient.writeObject(message);} catch (Exception e) {}
    } else if(!isBot){
        System.out.println(message);                
    }
}
