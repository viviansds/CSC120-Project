import java.util.Arrays;

public class Room {
    protected String name;
    protected boolean locked_door;
    protected String key_type;
    protected String entry_method;
    String[] items= {"air"};

    public Room(String name, boolean locked_door, String key_type){
        this.name = name;
        this.locked_door = locked_door;
        this.key_type= key_type;
        this.entry_method = "abc";
    }
    /*
     * Accessor for getlocked_door
     */
    public boolean getlocked_door() {
        return this.locked_door;
    }
    public String toString() {
        return "This "+ this.name + " needs a " + this.key_type + ".";
    }

    public String getEntry_method(){
        // System.out.println("I am here");
        return this.entry_method;
    }

    public void examine(){
        System.out.println(Arrays.toString(items));
    }
    public void unlock(String unlock_method){
        // System.out.println(unlock_method);
        // System.out.println(getEntry_method());
        if (locked_door){
            int i = 2;
            while( i > 0 ){
                if(unlock_method.equals(getEntry_method())){
                    locked_door=false;
                    System.out.println("Great job! You unlocked the door.");
                    i=0;
                }else{
                    System.out.println("Failed to Unlock, you have "+i+" more tries");
                    i -= 1;
                }
            }
            //game end here
        }
    }
    
    public static void main(String[] args) {
    Room demo= new Room("Bedroom",true,"key");
    System.out.println(demo);
    demo.examine();
    }
}
