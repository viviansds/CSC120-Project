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
        System.out.println("Nothing found in Toilet.");
    }

    public void Bathtub(){
        System.out.println("The bathtub was full of red water with nothing else.");
    }

    public void Shelves(){
        System.out.println("You found a plant, a mini shovel, and a towel.");
    }

    public void Mirror(){
        System.out.println("The mirror was not very clean, you could vaguely see some marks on it.");
        System.out.println();
    }

    public void Closet(){
        if(Bag_in_closet){
            System.out.println("You found an empty bag in the closet.");
        } else {
            System.out.println("Nothing is inside the closet.");
        }
       
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

