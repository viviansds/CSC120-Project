import java.util.Arrays;
public class Livingroom extends Room{

    /* Subclass attributes */
    String[] items= {"Sofa", "Carpet", "Fire place", "Television", "Floor_lamp with a broken light bulb"};
    protected int entry_code;
    protected int exit_code;
   
    public Livingroom(String name, boolean locked_door, String key_type){
        super(name, locked_door, key_type);
        entry_code=123;
        exit_code=3595;
        
    }
    public int getentry_code() {
        return entry_code;
    }
    public void exit(int code) {
        if (code == exit_code){
            System.out.println("Congradulations! You escaped the room!");
        }
    }
    public void examine(){
        System.out.println(Arrays.toString(items));
    }
    public void CheckSofa(){
        System.out.println("Under the sofa cushion, you found a candle. As you take a closer look, there seems to be something stuck inside the candle wax.");
    }
    public void CheckCarpet(){
        System.out.println("You found a Key Chain with a set of keys each labeling a letter from A-F." );
    }
    public void CheckFireplace(){
        System.out.println("After a long search in the ashes, you found a half burnt letter with the following messsage: ");
        System.out.println(" __    __    __    __ ");
        System.out.println(" __|  |__   |__|  |__ ");
    }   
    public void LitFireplace(){
        //if candle used near the fireplace
        System.out.println("As Candle get close to the fireplace, it started to melt and a note came out of the wax. The message wrote:");
        System.out.println("I'm the beginning of the end, the end of every place. I'm the beginning of eternity, the end of time and space. What am I?. If you know what I am, use me to find the right key to drive the car.");
    }
    public void Floorlamp(){
        LitFireplace();
        System.out.println("The light bulb is broken, but you still tried to turn on the floor lamp. Surprise! The switch is actually for turning on the fireplace. The fire place starts to lit up.");
    }

}
