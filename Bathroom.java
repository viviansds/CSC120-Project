import java.util.Arrays;
import java.util.Scanner;
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
    }

    public void Mirror(){
        System.out.println("The mirror is not very clean, you can vaguely see some marks on it.");
        System.out.println();
    }

    public void Closet(){
        System.out.println("There is an empty bag in the closet. Do you want to carry it? (yes/no)");
    }

    public void examine(){
        System.out.println(Arrays.toString(items));

    }

    // public static void main(String[] args) {
    //     Bathroom Bathroom= new Bathroom("Bathroom",true,"key");
    //     System.out.println(Bathroom);
    //     Bathroom.examine();
    //     System.out.print("What do you what to check in the room?");
    //     for (int i = 0; i < 8; i++) {
    //         try(Scanner check = new Scanner(System.in)){
    //             System.out.println("Which object do you wanna check?");
    //             String object = check.nextLine();
    //             if (object.equals("Toilet")){
    //                 Bathroom.Toilet();
    //             }else if (object.equals("Bathtub")){
    //                 Bathroom.Bathtub();
    //             }else if (object.equals("Shelves")){
    //                 Bathroom.Shelves();
    //                 try(Scanner status = new Scanner(System.in)){
    //                     System.out.println("Do you want to use them or not? (yes/no)");
    //                     String decision_key = status.nextLine();
    //                     if (decision_key.equals("yes")){
    //                         System.out.println("You unlock the door. Do you want to exit the bathroom or keep checking other things in the Bathroom?");
    //                         // scanner check whether go to next room or keep checking bathroom
    //                     }else if(decision_key.equals("no")){
    //                         System.out.println("You stuck in the room and missed the time.");
    //                         //game over
    //                     }
    //                 }
    //             }else if (object.equals("Mirror")){
    //                 Bathroom.Mirror();
    //                 try(Scanner status = new Scanner(System.in)){
    //                     System.out.println("You remember fog can make some stain more obvious. Are you going to try that? (yes/no)");
    //                     String decision_mirror = status.nextLine();
    //                 if(decision_mirror.equals("yes")){
    //                     System.out.println("Words appeared on the mirror: Don't lose track of time. Find the key.");
    //                 }
    //                 }
    //             }else if (object.equals( "Closet")){
    //                 Bathroom.Closet();
    //                 };    
    //             };
    //     }
    // }
}

