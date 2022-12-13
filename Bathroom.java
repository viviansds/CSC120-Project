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
     * see if the bag is still in the closet
     * @return Bag_in_closet
     */
    public boolean setBag_in_closet(){
        Bag_in_closet=false;
        return Bag_in_closet;
    }
    
    /*
     * print nothing is found in the tiolet
     */
    public void Toilet(){
        System.out.println("->Nothing found in Toilet.");
        System.out.println();
    }

    /*
     * print what is in the bathtub
     */
    public void Bathtub(){
        System.out.println("->The bathtub was full of red water with nothing else.");
        System.out.println();
    }

    /*
     * print what are on the shelves
     */
    public void Shelves(){
        System.out.println("->You found a plant, a mini shovel, and a towel.");
        System.out.println();
    }

    /*
     * print what is on the mirror
     */
    public void Mirror(){
        System.out.println("->The mirror was not very clean, you could vaguely see some marks on it.");
        System.out.println();
    }

    /*
     * print what is found in the closet
     * the result is depend on whether the bag has already been picked up before
     */
    public void Closet(){
        if(Bag_in_closet){
            System.out.println("->You found an empty bag in the closet.");
        } else {
            System.out.println("->Nothing is inside the closet.");
        }
    }

    public void examine(){
        System.out.print("This bathroom contains");
        System.out.println(Arrays.toString(items));

    }

}

