import java.util.Arrays;
public class Livingroom extends Room{

    /* Subclass attributes */
    String[] items= {"Sofa", "Carpet", "Fire place", "Television", "Floor_lamp"};
    protected int entry_code;
   
    public Livingroom(String name, boolean locked_door, String key_type){
        super(name, locked_door, key_type);
        entry_code=123;
    }
    public void exit() {
        System.out.println("Congradulations! You escaped the room!");
    }
    public void examine(){
        System.out.println(Arrays.toString(items));
    }
}
