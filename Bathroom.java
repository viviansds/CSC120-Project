/*
 * Bathroom class: The bathroom class contains clues found in bathroom-specific objects.
 * Final Project: The Escape room
 * @author Zhirou Liu, Yujie Gong, Vivian Wei
 * @version 14 December 2022
 */

import java.util.Arrays;

/*
 * This is a subclass of Room class, the Bathroom
 */
public class Bathroom extends Room {
    public boolean Bag_in_closet = true;
    String[] items= {"Toilet", "Bathtub", "Shelves", "Mirror", "Closet"};

    /*
     * constructor of the Bathroom
     */
    public Bathroom(String name, boolean locked_door, String exit_type){
        super(name, locked_door, exit_type);
    }

    /*
     * change the status of whether the bag is still inside the closet
     * @param a boolean true if there is still bag inside the closet not picked up
     */
    public void setBag_in_closet(boolean status){
        Bag_in_closet=status;
    }
    
    /*
     * print nothing is found in the tiolet
     */
    public void checkToilet(){
        System.out.println("->Nothing found in Toilet.");
        System.out.println();
    }

    /*
     * print what is in the bathtub
     */
    public void checkBathtub(){
        System.out.println("->The bathtub was full of red water with nothing else.");
        System.out.println();
    }

    /*
     * print what are on the shelves
     */
    public void checkShelves(){
        System.out.println("->You found a plant, a mini shovel, and a towel.");
        System.out.println();
    }

    /*
     * print what is on the mirror
     */
    public void checkMirror(){
        System.out.println("->The mirror was not very clean, you could vaguely see some marks on it.");
        System.out.println();
    }

    /*
     * print what is found in the closet
     * the result is depend on whether the bag has already been picked up before
     */
    public void checkCloset(){
        if(Bag_in_closet){
            System.out.println("->You found an empty bag in the closet.");
        } else {
            System.out.println("->Nothing is inside the closet.");
        }
    }
    /*
     * Override examine to reflect the items inside Bathroom
     */
    public void examine(){
        System.out.print("This bathroom contains");
        System.out.println(Arrays.toString(items));

    }

}

