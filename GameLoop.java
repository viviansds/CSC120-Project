import java.util.Scanner;
public class GameLoop {
    public static void main(String[] arguments) {
        //Bathroom
        Bathroom Bathroom= new Bathroom("Bathroom",true,"key");
        System.out.println(Bathroom);
        Bathroom.examine();
        System.out.print("What do you what to check in the room?");
        for (int i = 0; i < 8; i++) {
            try(Scanner check = new Scanner(System.in)){
                System.out.println("Which object do you wanna check?");
                String object = check.nextLine();
                if (object.equals("Toilet")){
                    Bathroom.Toilet();
                }else if (object.equals("Bathtub")){
                    Bathroom.Bathtub();
                }else if (object.equals("Shelves")){
                    Bathroom.Shelves();
                    try(Scanner status = new Scanner(System.in)){
                        System.out.println("Do you want to use them or not? (yes/no)");
                        String decision_key = status.nextLine();
                        if (decision_key.equals("yes")){
                            System.out.println("You unlock the door. Do you want to exit the bathroom or keep checking other things in the Bathroom?");
                            // scanner check whether go to next room or keep checking bathroom
                        }else if(decision_key.equals("no")){
                            System.out.println("You stuck in the room and missed the time.");
                            //game over
                        }
                    }
                }else if (object.equals("Mirror")){
                    Bathroom.Mirror();
                    try(Scanner status = new Scanner(System.in)){
                        System.out.println("You remember fog can make some stain more obvious. Are you going to try that? (yes/no)");
                        String decision_mirror = status.nextLine();
                    if(decision_mirror.equals("yes")){
                        System.out.println("Words appeared on the mirror: Don't lose track of time. Find the key.");
                    }
                    }
                }else if (object.equals( "Closet")){
                    Bathroom.Closet();
                    };    
                };
        }

        //bedroom section
        Bedroom bedroom = new Bedroom("Bedroom", true, "key");
        System.out.println(bedroom);
        bedroom.examine();
        for (int i = 0; i < 5; i++) {
            try(Scanner check = new Scanner(System.in)){
                System.out.println("Which object do you wanna check?");
                String object = check.nextLine();
                if (object.equals("Bed")){
                    bedroom.Bed();
                }else if (object.equals("Closet")){
                    bedroom.Closet();
                }else if (object.equals("Drawers")){
                    bedroom.Drawers();
                }else if (object.equals("Curtains")){
                    bedroom.Curtains();
                }else if (object.equals( "Lamp")){
                    try(Scanner status = new Scanner(System.in)){
                        System.out.println("Input On/Off to change the status of the lamp");
                        String OnOff = status.nextLine();
                        if (OnOff.equals("On")){
                            bedroom.turn_on_lamp();
                        }else if (OnOff.equals("Off")){
                            bedroom.turn_off_lamp();
                        }
                    };    
                };
            }
        }
        
    }
}