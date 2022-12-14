/*
 * Character class: The character class contains actions and traits that the player need to interact with the rooms
 * Final Project: The Escape room
 * @author Zhirou Liu, Yujie Gong, Vivian Wei
 * @version 14 December 2022
 */

import java.util.ArrayList; // import the ArrayList class

/*
 * This class is the Character
 */
public class Character {
    public String name;
    public int position;//track the person's location, 0=bathroom,1=bedroom, 2= living room, 3=outside
    boolean haveBag = false;
    boolean haveKey = false;
    ArrayList<String> Bag = new ArrayList<String>();

    /*
     * constructer of the Character class
     */
    public Character(String name){
        this.name = name;
        this.position = 0;
    }

    /*
     * character can enter the room and print out where they are
     * @param room_num  change the number represent the position to the room_num the character wants to enter
     */
    public void enter(int room_num) {
        if (position!= room_num){
            if (room_num==0){
                position = 0;
                System.out.println("->You are now inside the bathroom.");
            }else if (room_num==1){
                position = 1;
                System.out.println("->You are now inside the bedroom");
            }else if(room_num==2){
                position = 2;
                System.out.println("->You are now inside the living room");
            }
        }else{
            System.out.println("->You are already inside the room.");
        }
    }

    /*
     * the character can pickup items and save for later use
     * @param item
     */
    public void pickup(String item){
        if (haveBag){
            System.out.println("->You just pick up the " + item);
            Bag.add(item);
            System.out.println(Bag);
        }else{
            System.out.println("->You can't have this item because you don't have a bag.");
        }
    }

    /*
     * change the status of whether the person have bag
     * @return status: a boolean true if the person have key
     */
    public void setHaveBag(boolean status){
        haveBag=status;
        System.out.println("->You got the bag and were able to pick up things.");
    }

    /*
     * change the status of whether the person have key
     *  @param status: a boolean true if the person have key
     */
    public void setHaveKey(boolean status){
        haveKey = status;
        System.out.println("->God job! You found a key in the plant.");
    }
    
    /*
     * burn the candle
     */
    public void burnCandle(){
        if(haveItem("candle")){
            Bag.remove("candle");
            System.out.println("Bag has"+Bag);
            System.out.println("As Candle start burning, it started to melt and a note came out of the wax. The message wrote:");
            System.out.println("I'm the beginning of the end, the end of every place. I'm the beginning of eternity, the end of time and space. What am I?. If you know what I am, use me to identify the right key in the keychains to drive the car.");
        }else{
            System.out.println("You don't have a candle in your bag yet");
        }
        
    }

    /*
     * see what items are in the bag
     * @param item 
     * @return haveItem:the items in the bag
     */
    public boolean haveItem(String item){
        boolean haveItem=false;
        if (Bag.contains(item)){
            haveItem=true;
        }else{
            haveItem=false;
        }return haveItem;
    }
}

