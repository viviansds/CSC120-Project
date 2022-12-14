/*
 * Livingroom class: The livingroom class contains clues found in livingroom-specific objects.
 * Final Project: The Escape room
 * @author Zhirou Liu, Yujie Gong, Vivian Wei
 * @version 14 December 2022
 */

import java.util.Arrays;

/*
 * This is a subclass of Room class, the Livingroom
 */
public class Livingroom extends Room{
    /* Subclass attributes */
    String[] items= {"Sofa", "Carpet", "Fire place", "TV", "Floor lamp"};
    protected String entry_method;
    protected String exit_code;
    public boolean candle_status = true;
    public boolean keychain_status = true;
    protected boolean locked_house;//locked front door
   
    /*
     * constructor of the Livingroom
     */
    public Livingroom(String name, boolean locked_door, String exit_type){
        super(name, locked_door, exit_type);
        this.entry_method="YDH358";
        this.exit_code="3595";
        this.locked_house=true;
    }

    /*
     * see if the house is locked
     * @return getlocked_house
     */
    public boolean getlocked_house() {
        return this.locked_house;
    }

    /*
     * exit the house
     * @param code
     * @return locked_house status of the lock of house
     */
    public boolean exitHouse(String code) {
        if (locked_house){
            if (code.equals(exit_code)){
                System.out.println("Congradulations! You escaped the house!");
                locked_house = false;
            }
        } 
        return locked_house;
    }

    /*
     * see what are contained in the livingroom
     */
    public void examine(){
        System.out.print("This living room contains");
        System.out.println(Arrays.toString(items));
    }
    
    /*
     * override getEntry_method
     */
    public String getEntry_method(){
        return this.entry_method;
    }

    /*
     * print the clues on the sofa
     */
    public void checkSofa(){
        if(candle_status){
            System.out.println("The sofa is L-shaped. Under the sofa cushion, you found a candle. As you take a closer look, there seems to be something stuck inside the candle wax.");
        }else{
            System.out.println("The sofa is L-shaped.");
        }
        
    }

    /*
     * change the status of whether keychains is still under the carpet candle is still in the sofa
     * @param a boolean true if there is still candle not picked up  
     */
    public void setCandle_status(boolean status){
        candle_status=status;
    }

    /*
     * change the status of whether keychains is still under the carpet
     *  @param a boolean true if there is still keychains are not picked up
     */
    public void setKeychain_status(boolean status){
        keychain_status=false;
    }

    /*
     * print the clues on the carpet
     */
    public void checkCarpet(){
        if(keychain_status){
            System.out.println("You found a Key Chain with a set of keys each labeling a letter from A-F." );
        }else{
            System.out.println("Nothing found under the carpet");
        }
    }

    /*
     * print the clues in the fireplace
     */
    public void checkFireplace(){
        System.out.println("After a long search in the ashes, you found a half burnt letter with the following messsage: ");
        System.out.println(" __    __    __    __ ");
        System.out.println(" __|  |__   |__|  |__ ");
    }   
    
    /*
     * print the clues in the floorlamp
     */
    public void Floorlamp(){
        System.out.println("The light bulb is broken, but you still tried to turn on the floor lamp. Surprise! The switch is actually for turning on the fireplace. The fire place starts to lit up.");     
    }

    /*
     * print shut off the fire place
     */
    public void ShutOffFireplace(){
        System.out.println("You shut off the fire place.");
    }

    /*
     * print turn on TV and ask what the user what to do next
     */
    public void TurnOnTV(){
        System.out.println("You turned on the TV. It was playing your favorite show on Netflix. Do you want to keep watching it? (yes/switch a channel/stop watching and turn off tv)");
    }

    /*
     * print turn on TV
     */
    public void TurnOffTV(){
        System.out.println("You turned off the TV.");
    }
}

