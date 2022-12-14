/*
 * Bedroom class: The bedroom class contains clues found in bedroom-specific objects.
 * Final Project: The Escape room
 * @author Zhirou Liu, Yujie Gong, Vivian Wei
 * @version 14 December 2022
 */

import java.util.Arrays;

/*
 * This is a subclass of Room class, the Bedroom
 */
public class Bedroom extends Room{
    String[] items= {"Bed", "Closet", "Drawers", "Curtain", "Lamp"};
    public boolean lamp_status = false;
    
    /*
     * constructor of the Bedroom class
     */
    public Bedroom(String name, boolean locked_door, String exit_type, String entry_method){
        super(name, locked_door, exit_type);
        this.entry_method = "key";
    }

    /*
     * print nothing is on the bed
     */
    public void Bed(){
        System.out.println("->Nothing found here!");
    }

    /*
     * print what are in the closet
     */
    public void Closet(){
        System.out.println("->There are three hangers in the closet. ");
    }

    /*
     * print what is in the drawer
     */
    public void Drawers(){
        System.out.println("->You found a sticky note that reads 'You can Do tHis'.");
    }

    /*
     * print the clues in the curtains
     */
    public void Curtains(){
        System.out.println("->You opened the curtain and you saw two red numbers '5' '8' written on the window. ");
    }

    /*
     * turn on the lamp if the lamp is not on
     */
    public void turn_on_lamp(){
        if (!lamp_status){
        System.out.println("->You turned on the lamp. As the room got brighter, you saw a note sticked inside the lamp saying that 'From letter to number, from small to big.'");
        lamp_status = true;
        }else{
            System.out.println("->The lamp is already on!");
        }
    }

    /*
     * turn off the lamp if the lamp is not off
     */
    public void turn_off_lamp(){
        if (lamp_status){
        System.out.println("->You turned off the lamp");
        lamp_status = false;
        }else{
            System.out.println("->The lamp is already off");
        }
    }

    /*
     * print what the bedroom contains
     */
    public void examine(){
        System.out.print("This bedroom contains");
        System.out.println(Arrays.toString(items));
    }

    /*
     * override getEntry_method
     */
    public String getEntry_method(){
        return this.entry_method;
    }
}





    




   

    

