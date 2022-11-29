import java.util.Arrays;

public class Room {
    protected String name;
    protected boolean locked_door;
    protected String key_type;
    String[] items= {"air"};

    public Room(String name, boolean locked_door, String key_type){
        this.name = name;
        this.locked_door = locked_door;
        this.key_type= key_type;
    }

    public String toString() {
        return "This "+ this.name + " needs a " + this.key_type + ".";
    }

    public void examine(){
        System.out.println(Arrays.toString(items));
    }
    public void enter() {
        System.out.println("You are now inside " + this.name + " on the ground floor.");
    }
    
    public static void main(String[] args) {
    Room demo= new Room("Bedroom",true,"key");
    System.out.println(demo);
    demo.examine();
    }
}
