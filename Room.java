/*
 * Room class: The room class contains basic feature of a room and work as a parent class for future inheretence.
 * Final Project: The Escape room
 * @author Zhirou Liu, Yujie Gong, Vivian Wei
 * @version 14 December 2022
 */

import java.util.Arrays;

/*
 * parent class Room
 */
public class Room {
    protected String name;
    protected boolean locked_door;
    protected String exit_type;
    protected String entry_method;
    String[] items= {"air"};

    /*
     * constructor of the room
     */
    public Room(String name, boolean locked_door, String exit_type){
        this.name = name;
        this.locked_door = locked_door;
        this.exit_type= exit_type;
        this.entry_method = "abc";
    }

    /*
     * Accessor for getlocked_door
     * @return this.locked_door lock status of the door
     */
    public boolean getlocked_door() {
        return this.locked_door;
    }

    /*
     * create the sentnce showing what is needed to exit
     * @return string sentence
     */
    public String toString() {
        return "This "+ this.name + " needs a " + this.exit_type + " to exit.";
    }

    /*
     * Accessor for entry_method
     * @return this.entry_method in order to unlock the room
     */
     public String getEntry_method(){
        return this.entry_method;
    }

    /*
     * print the items contained in the room
     */
    public void examine(){
        System.out.println(Arrays.toString(items));
    }

    /*
     * unlock the door if the input unlock_method is the same as the entry method of the room
     * @param unlock_method 
     * @return unlock
     */
    public boolean unlock(String unlock_method){
        boolean unlock = false;
        if (locked_door){
                if(unlock_method.equals(getEntry_method())){
                    locked_door=false;
                    System.out.println("->Great job! You unlocked the door.");
                    unlock = true;
                }
        }else{
            unlock = true;
        }return unlock;
    }
    //Main for testing 
    public static void main(String[] args) {
    Room demo= new Room("Bedroom",true,"key");
    System.out.println(demo);
    demo.examine();
    }
}
