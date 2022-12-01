import java.util.ArrayList; // import the ArrayList class

public class Character {
    public String name;
    public int position;//track the person's location, 0=bathroom,1=bedroom, 2= living room, 3=outside
    ArrayList<String> Collection = new ArrayList<String>();

    public Character(String name){
        this.name = name;
        this.position = 0;
    }

    public String GoToDoor(String room_name) {
        return "You are in front of"+room_name;// add lock status later
    }
    public void unlock(String door){
        // if (Room.getlocked_door());
    }

}

