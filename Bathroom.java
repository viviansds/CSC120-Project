import java.util.Arrays;
public class Bathroom extends Room {

    public boolean finding_key;
    String[] items= {"Toilet", "Bathtub", "Shelves", "Mirror", "Closet"};

    public Bathroom(String name, boolean locked_door, String key_type){
        super(name, locked_door, key_type);

    }

    public void Toilet(){
        System.out.println("Nothing found in Toilet.");
    }

    public void Bathtub(){
        System.out.println("The bathtub is full of red water with nothing else.");
    }

    public void Shelves(){
        System.out.println("There is a plant, a mini shovel, and a towel.");
        finding_key();
    }

    public boolean finding_key(){
        System.out.println("Do you want to use them or not? (Yes/No)");
        // if user input Yes, return ture
        return this.finding_key;
    }

    public void examine(){
        System.out.println(Arrays.toString(items));

    }

    public static void main(String[] args) {
        Bathroom thisBathroom= new Bathroom("Bathroom",true,"key");
        System.out.println(thisBathroom);
        thisBathroom.examine();
        }
}
