
import java.util.Arrays;
public class Bedroom extends Room{
    
    String[] items= {"Bed", "Closet", "Drawers", "Curtain", "Lamp"};

   
    public Bedroom(String name, boolean locked_door, String key_type){
        super(name, locked_door, key_type);

    }

    public void Bed(){
        System.out.println("Nothing find here!");

    }

    public void Closet(){
        System.out.println("There are three hangers in the closet. ");
    }

    public void Drawers(){
        System.out.println("A letter shows up here with letters YHD shown up on it.");
    }

    public void curtains(){
        System.out.println("You open the curtain and you see two red numbers 5 8 on the window. ");
    }

    public void turn_on_lamp(){
        System.out.println("You turn on the lamp. The room gets brighter but nothing is here. ");
    }

    public void turn_off_lamp(){
        System.out.println("You turn off the lamp");
    }

    public void examine(){
        System.out.println(Arrays.toString(items));

    }

public static void main(String[] args) {
    Bedroom bedroom = new Bedroom("Bedroom", true, "key");
    System.out.println(bedroom);
    bedroom.examine();


    




   

    

}

}
