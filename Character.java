import java.util.ArrayList; // import the ArrayList class

public class Character {
    public String name;
    public int position;//track the person's location, 0=bathroom,1=bedroom, 2= living room, 3=outside
    boolean switch_channel=false;
    ArrayList<String> Collection = new ArrayList<String>();

    public Character(String name){
        this.name = name;
        this.position = 0;
    }

    public String GoToDoor(String room_name) {
        return "You are in front of"+room_name;// add lock status later
    }
   
    public void enter(int room_num) {
        if (position!= room_num){
            System.out.println("You are now inside");
        }else{
            System.out.println("You are already inside this room.");
        }
    }
    public boolean SwitchChannel(String response){
        if (response.equals("yes")){
            switch_channel=true;
        }
        return switch_channel;
    }

}

