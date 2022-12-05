import java.util.Arrays;

public class Room {
    protected String name;
    protected boolean locked_door;
    protected String exit_type;
    protected String entry_method;
    String[] items= {"air"};

    public Room(String name, boolean locked_door, String exit_type){
        this.name = name;
        this.locked_door = locked_door;
        this.exit_type= exit_type;
        this.entry_method = "abc";
    }
    /*
     * Accessor for getlocked_door
     */
    public boolean getlocked_door() {
        return this.locked_door;
    }
    public String toString() {
        return "This "+ this.name + " needs a " + this.exit_type + " to exit.";
    }

    public String getEntry_method(){
        return this.entry_method;
    }

    public void examine(){
        System.out.println(Arrays.toString(items));
    }
    public boolean unlock(String unlock_method){
        boolean unlock = false;
        if (locked_door){
                if(unlock_method.equals(getEntry_method())){
                    locked_door=false;
                    System.out.println("Great job! You unlocked the door.");
                    unlock = true;
                }
        }else{
            System.out.println("The door is already unlocked");
            unlock = true;
        }return unlock;
    }

    public static void main(String[] args) {
    Room demo= new Room("Bedroom",true,"key");
    System.out.println(demo);
    demo.examine();
    }
}
