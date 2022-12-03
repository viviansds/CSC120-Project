
import java.util.Arrays;
public class Bedroom extends Room{
    public boolean get_code;
    String[] items= {"Bed", "Closet", "Drawers", "Curtain", "Lamp"};
    protected String exit_code;
    protected String entry_key;
   
    public Bedroom(String name, boolean locked_door, String key_type){
        super(name, locked_door, key_type);
        entry_key = "key";
        // exit_code="YHD358";

    }

    public String getentry_key(){
        return entry_key;
    }

    // public void exit(String code) {
    //     if (code.equals(exit_code)){
    //         System.out.println("Correct Password!");
    //     }
    // }

    public void Bed(){
        System.out.println("Nothing find here!");

    }

    public void Closet(){
        System.out.println("There are three hangers in the closet. ");
    }

    public void Drawers(){
        System.out.println("A letter shows up here with letters YHD bolded.");
    }

    public void Curtains(){
        System.out.println("You open the curtain and you see two red numbers 5 8 on the window. ");
    }

    public void turn_on_lamp(){
        System.out.println("You turn on the lamp. As the room gets brighter, you saw a note stick inside the lamp saying that 'from letter to number, from small to big.'");
    }

    public void turn_off_lamp(){
        System.out.println("You turn off the lamp");

    }
    public void examine(){
        System.out.println(Arrays.toString(items));
    }


    

}





    




   

    

