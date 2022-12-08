import java.util.Arrays;
// import java.util.Scanner;
public class Bathroom extends Room {

    public boolean Bag_in_closet = true;
    String[] items= {"Toilet", "Bathtub", "Shelves", "Mirror", "Closet"};

    public Bathroom(String name, boolean locked_door, String exit_type){
        super(name, locked_door, exit_type);

    }
    public boolean setBag_in_closet(){
        Bag_in_closet=false;
        return Bag_in_closet;
    }
    
    public void Toilet(){
        System.out.println("->Nothing found in Toilet.");
    }

    public void Bathtub(){
        System.out.println("->The bathtub was full of red water with nothing else.");
    }

    public void Shelves(){
        System.out.println("->You found a plant, a mini shovel, and a towel.");
    }

    public void Mirror(){
        System.out.println("->The mirror was not very clean, you could vaguely see some marks on it.");
        System.out.println();
    }

    public void Closet(){
        if(Bag_in_closet){
            System.out.println("->You found an empty bag in the closet.");
        } else {
            System.out.println("->Nothing is inside the closet.");
        }
       
    }

    public void examine(){
        System.out.print("This bedroom contains");
        System.out.println(Arrays.toString(items));

    }

}

