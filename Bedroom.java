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
    public void checkBed(){
        System.out.println("->Nothing found here!");
    }

    /*
     * print what are in the closet
     */
    public void checkCloset(){
        System.out.println("->There are three hangers in the closet. ");
    }

    /*
     * print what is in the drawer
     */
    public void checkDrawers(){
        System.out.println("->You found a sticky note that reads 'You can Do tHis'.");
    }

    /*
     * print the clues in the curtains
     */
    public void checkCurtains(){
        System.out.println("->You opened the curtain and you saw two red numbers '5' '8' written on the window. ");
    }

    /* Turn on and off the lamp
     * @param String OnOff: commands to adjust on/off status
    */
    public boolean lamp(String OnOff){
        if (OnOff.equals("on")){
            if (!lamp_status){//only turns on lamp when lamp_status is false
                System.out.println("->You turned on the lamp. As the room got brighter, you saw a note sticked inside the lamp saying that 'From letter to number, from small to big.'");
                lamp_status = true;
            }else{
                System.out.println("->The lamp is already on!");
            }
        }else if (OnOff.equals("off")){
            if(lamp_status){//only turns off lamp when lamp_status is true
                System.out.println("->You turned off the lamp");
                lamp_status = false;
            }else{
                System.out.println("->The lamp is already off");
            }
        }
            
        return lamp_status;
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





    




   

    

