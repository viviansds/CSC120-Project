import java.util.Scanner;
public class GameLoop {
    public static void main(String[] arguments) {
        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;
        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        // This could be replaced with a more interesting opening
        System.out.println("****************************");
        System.out.println("WELCOME TO THE ESCAPE ROOM");
        System.out.println("****************************");

        //Background Story
        System.out.println("Today is December 21th.");
        System.out.println("You are a secret FBI agent and your last assigned mission of this year is to appear in court and identify the suspect at noon today.");
        System.out.println("This morning, you are walking down the street, and out of nowhere, the people from the criminal gang kidnap you.");
        System.out.println("After a long while, you woke up in a bath tub around 10:30 and found yourself locked inside a bathroom of an unknown house.");
        System.out.println("All the rooms inside the house are locked and it is your job to use the clues around you to unlock the door and be at the court in time. Good Luck!");
        
        // Instructions are sometimes helpful
        System.out.println("Ready to Start, Enter 'START' or Enter 'HELP' to see a list of useful commands");

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