import java.util.Arrays;
public class Livingroom extends Room{

    /* Subclass attributes */
    String[] items= {"Sofa", "Carpet", "Fire place", "Television", "Floor_lamp"};
    protected int entry_code;
   
    public Livingroom(String name, boolean locked_door, String key_type){
        super(name, locked_door, key_type);
        entry_code=123;
    }
    public int getentry_code() {
        return entry_code;
    }
    public void exit() {
        System.out.println("Congradulations! You escaped the room!");
    }
    public void examine(){
        System.out.println(Arrays.toString(items));
    }
    public void CheckSofa(){
        System.out.println("Under the sofa cushion, you found a candle. As you take a closer look, there seems to be something stuck inside the candle wax.");
    }
    public void CheckCarpet(){
        System.out.println("You found a key." );
    }
    public void CheckFireplace(){
        System.out.println("After a long search in the ashes, you found a half burnt letter with the following messsage: ");
        System.out.println(" __    __    __    __ ");
        System.out.println(" __|  |__   |__|  |__ ");
    }   

}
