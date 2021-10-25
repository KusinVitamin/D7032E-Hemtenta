package GameModes;

public abstract class GameModeFactory {
    private String name;
    private int id;

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public int GameMode(){
        return id;
    } 

    public void setID(int newID){
        id = newID;
    }

    public void StartGame(){

    }
    
}
