
import java.util.Arrays;
public class Bedroom extends Room{
    String[] items= {"Bed", "Closet", "Drawers", "Curtain", "Lamp"};
    public boolean lamp_status = false;
    
   
    public Bedroom(String name, boolean locked_door, String exit_type, String entry_method){
        super(name, locked_door, exit_type);
        this.entry_method = "key";
    }


    public void Bed(){
        System.out.println("Nothing found here!");
    }

    public void Closet(){
        System.out.println("There are three hangers in the closet. ");
    }

    public void Drawers(){
        System.out.println("A letter shows up here with letters 'Y' 'H' 'D' bolded.");
    }

    public void Curtains(){
        System.out.println("You opened the curtain and you saw two red numbers '5' '8' written on the window. ");
    }

    public void turn_on_lamp(){
        if (!lamp_status){
        System.out.println("You turned on the lamp. As the room got brighter, you saw a note sticked inside the lamp saying that 'From letter to number, from small to big.'");
        lamp_status = true;
        }else{
            System.out.println("The lamp is already on!");
        }
    }

    public void turn_off_lamp(){
        if (lamp_status){
        System.out.println("You turned off the lamp");
        lamp_status = false;
        }else{
            System.out.println("The lamp is already off");
        }

    }
    public void examine(){
        System.out.println(Arrays.toString(items));
    }

    //override getEntry_method
    public String getEntry_method(){
        return this.entry_method;
    }
}





    




   

    

