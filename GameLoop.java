/*
 * Gameloop class: The Gameloop class allows the player to discover clues as they move through various room locations.
 * Final Project: The Escape room
 * @author Zhirou Liu, Yujie Gong, Vivian Wei
 * @version 14 December 2022
 */

import java.util.Scanner;

/*
 * game loop connect all the subclasses together
 * print guideline words and take user input
 */ 
public class GameLoop {
    /*
     * Print a statement whenver the user inputs an invalid input
     */
    public static void InvalidInput() {
        System.out.println("->Sorry, Invalid input.");
    }
    
    /* 
     * Print background story
     */
    public static void background() {
        System.out.println(
            "--------------------------------------------------------------------------------------------------------------------------");
    System.out.println("Today is December 21st.");
    System.out.println(
            "You are a secret FBI agent and your last assigned mission of this year is to appear in court and identify the suspect at noon today.");
    System.out.println(
            "This morning, you were walking down the street, and out of nowhere, the people from the criminal gang kidnapped you.");
    System.out.println(
            "After a long while, you woke up in a bath tub around 10:30 and found yourself locked inside a bathroom of an unknown house.");
    System.out.println(
            "All the rooms inside the house are locked and it is your job to use the clues around you to unlock the door and be at the court in time.");
    System.out.println("Good Luck!");
    System.out.println(
            "--------------------------------------------------------------------------------------------------------------------------");
    
    }
    
    /*
     * Print welcome message
     * @param room  the room the character is currently in
     */
    public static void welcomeMessage(String room){
        if (room.equals("bathroom")){
            System.out.println("=======================================================");
            System.out.println("Which object do you wanna check?");
            System.out.println("Type 'unlock' if you are ready to try to use the key!");
            System.out.println("Type 'help' if you need additional tip to proceed.");
            System.out.println("Type 'quit' if you want to end the game.");
            System.out.println("=======================================================");
        }else{ 
            System.out.println("=======================================================");
            System.out.println("Which object do you wanna check?");
            System.out.println("Type 'unlock' if you are ready to try to use the key!");
            System.out.println("Type 'help' if you need additional tip to proceed.");
            System.out.println("Type 'go back' if you want to go to a previous room");
            System.out.println("Type 'quit' if you want to end the game.");
            System.out.println("=======================================================");
        }
        
    }
    
    /*
     * Print exit message when unlocked the next room 
     */
    public static void exitPrompt(){
        System.out.println("->You unlocked the door. What do you want to do next? (exit the room / check other things in the room)");
    }

    
    /* Prints a goodbye message and end the program */
    public static void goodbye(){
        System.out.println("->Thank you for playing, bye!");
        System.exit(0);
    }
    
    public static void main(String[] arguments) {
        // This is a "flag" to let us know when the game loop should end
        boolean stillPlaying = true;
        // This is a "flag" to let us know when the person want to stop searching
        boolean stillSearching = true;

        // We'll use this to get input from the user.
        Scanner user_input = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        // Game opening
        System.out.println("****************************");
        System.out.println("WELCOME TO THE ESCAPE ROOM");
        System.out.println("****************************");

        // Instructions are sometimes helpful
        System.out.println("Ready to play? Enter 'START'");
        userResponse = user_input.nextLine().toUpperCase();
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");



        // START GAME
        if (userResponse.equals("START")) {
            // Background Story
            background();

            // Initialize rooms and characters
            Bathroom Bathroom = new Bathroom("Bathroom", false, "key");
            Bedroom bedroom = new Bedroom("Bedroom", true, "passcode", "key");
            Livingroom livingroom = new Livingroom("Living Room", true, "entry_code");
            Character person = new Character("You");

            // Start playing loop
            while (stillPlaying) {
                // Bathroom
                while (person.position == 0) {
                    // when position equals 0, the character is in Bathroom
                    System.out.println(Bathroom);
                    String key = "key";//initialize a key to be discoverd in the 'closet' case for unlocking the bathroom
                    while (stillSearching) {
                        // stillSearching keep the user in this loop
                        welcomeMessage("bathroom");
                        Bathroom.examine();
                        System.out.println();
                        // change all user format to lowercase
                        String object = user_input.nextLine().toLowerCase();
                        // Check Objects in the room depending on user's inputs
                        switch (object){
                        //When user checks the toilet, they will find nothing in it. This is a useless clue.
                        case "toilet": 
                            Bathroom.checkToilet();
                            System.out.println();
                            break;
                        //When user checks the bathtub, they will find nothing in it. This is a useless clue.
                        case "bathtub": 
                            Bathroom.checkBathtub();
                            System.out.println();
                            break;
                        //When user checks the mirror, the prompt will ask whether they want to fog the mirror for further clue. This is another useless clue.
                        case "mirror":
                            Bathroom.checkMirror();
                            //further clues
                            System.out.println(
                                    "->You remembered fog can make some stain more obvious. Do you want to fog the room by turning on hot water? (yes/no)");
                            String decision_mirror = user_input.nextLine().toLowerCase();
                            if (decision_mirror.equals("yes")) {
                                System.out.println(
                                        "->Words appeared on the mirror: Don't lose track of time. Find the key.");
                                System.out.println();
                            }
                            break;
                        //When user checks the closet, they will discover a bag that allow the user to pick up things. 
                        case "closet": 
                            Bathroom.checkCloset();
                            if (Bathroom.Bag_in_closet) {//The prompt will ask them whether they will want to pick it up. The prompt will only shows up when the bag is still inside the closet.
                                System.out.println("->Do you want to carry it? (yes/no)");
                                String decision_bag = user_input.nextLine().toLowerCase();
                                if (decision_bag.equals("yes")) {
                                    person.setHaveBag(true);//once the player collects the bag inside the closet, they can pick up other objects
                                    System.out.println();
                                    Bathroom.setBag_in_closet(false);
                                } else if (decision_bag.equals("no")) {
                                    System.out.println("->Okay.");
                                    System.out.println();
                                } else {//When the user inputs unexpected message, print a default invalid input message.
                                    InvalidInput();
                                    System.out.println();
                                }
                            }
                            break;
                        //When user checks the shelves, the shelves contains a shovel, a towel and a small plant.
                        case "shelves": 
                            Bathroom.checkShelves();
                            if (!person.haveKey) {//if the user do not have the key yet, prompt will ask them if they want to dig up the plant to get the key.
                                System.out.println(
                                        "->Do you want to use the shovel to dig the plant and see what will happen? (yes/no)");
                                String decision_shovel = user_input.nextLine().toLowerCase();
                                if (decision_shovel.equals("yes")) {
                                    person.setHaveKey(true);
                                    System.out.println("->Do you want to use them or not? (yes/no)");//a further prompt ask them whether they want to unlock the door
                                    String decision_key = user_input.nextLine().toLowerCase();
                                    if (decision_key.equals("yes")) {
                                        while(bedroom.unlock(key)){
                                            exitPrompt();
                                            String exit_decision = user_input.nextLine().toLowerCase();
                                            if (exit_decision.equals("exit the room")) {
                                                person.enter(1);//the user enter position 1, which is the bathroom
                                                stillSearching = false;
                                                break;
                                            } else if (exit_decision.equals("check other things in the room")) {
                                                stillSearching = true;//allow users to keep checking other things in the room
                                                break;
                                            } else { // invalid input
                                                InvalidInput();
                                                System.out.println();
                                            }
                                        };
                                    } else if (decision_key.equals("no")) {//if the user do not use the key at that moment, they are stuck and lose the game.
                                        System.out.println(
                                                "->You were stuck in the room and couldn't unlock to go outside. Mission failed.");
                                        goodbye();
                                    } else {//When the user inputs unexpected message, print a default invalid input message.
                                        InvalidInput();
                                        System.out.println();
                                    }
                                } else if (decision_shovel.equals("no")) {
                                    System.out.println("->Okay.");
                                    System.out.println();
                                } else {//When the user inputs unexpected message, print a default invalid input message.
                                    InvalidInput();
                                    System.out.println();
                                }
                            }
                            break;
                        //When user inputs unlock, the door will unlock only if they found the key. 
                        case "unlock":  
                            if (person.haveKey) {
                                Bathroom.unlock(key);
                                person.enter(1);//the user enter position 1, which is the bathroom
                                stillSearching = false;
                            } else {
                                System.out.println("->The bathroom is locked. Try to find a key inside this room.");
                                System.out.println();
                            }
                            break;
                        //When the user inputs help, print out the instruction to guide the user to the next step of the game
                        case "help":
                            System.out.println(
                                    "->Type a name of the item in the room to start searching. For example, type 'closet'.");
                            System.out.println();
                            break;
                        //When the user inputs quit, print out the message to end the game
                        case "quit":
                            goodbye();
                            break;
                        //When the user inputs unexpected message, print a default invalid input message.
                        default:
                            InvalidInput();
                            System.out.println();
                        }
                    }
                }
                // Bedroom
                while (person.position == 1) {// when position equals 1, the character is in bedroom
                    stillSearching = true;
                    System.out.println(
                            "You have unlocked the bedroom! Type 'Bathroom' if you want to go back to bathroom. Hit enter to continue!");
                    String bathroom_name1 = user_input.nextLine();
                    if (bathroom_name1.equals("Bathroom")) {
                        person.enter(0);
                    } else {// start searching in bedroom
                        System.out.println("=======================================================");
                        System.out.println(
                            "You saw there is a lock on the door. You can either input letters or numbers to the lock, and it requires six digits. ");
                        System.out.println(bedroom);
                        int count = 3;//initialize a counter to keep track of the times that the user have left to try inputting passcode
                        while (stillSearching && count > 0) {
                            //stillSearching keep the user in this loop. Set the maximum times the user can try the code.
                            welcomeMessage("bedroom");
                            bedroom.examine();
                            System.out.println();
                            String object = user_input.nextLine().toLowerCase();
                            if (object.equals("go back")){//see if the user want to go back to the opened rooms
                                break;
                            }
                            // Check objects in the bedroom depending on user's input
                            switch(object){
                            case "bed":
                            //When user checks the bed, they will find nothing in it. This is a useless clue.
                                bedroom.checkBed();
                                System.out.println();
                                break;
                             //When user checks the closet, closet will have three hangers representing the clue '3'.
                            case "closet":
                                bedroom.checkCloset();
                                System.out.println();
                                break;
                            //When user checks the drawers, drawers will have a note representing the clue 'YDH'.
                            case "drawers":
                                bedroom.checkDrawers();
                                System.out.println();
                                break;
                            //When user checks the curtain, curatain will display a note representing the clue '58'.
                            case "curtain":
                                bedroom.checkCurtains();
                                System.out.println();
                                break;
                            //When user checks the lamp, the lamp could be turned on or off based on user's input and display a message revealing the order of the passcode.
                            case "lamp":
                                System.out.println("->Input (On/Off) to change the status of the lamp");
                                String OnOff = user_input.nextLine().toLowerCase();
                                bedroom.lamp(OnOff);
                                break;
                            //When user inputs unlock, the door will only unlock if the passcode is correct.
                            case "unlock":
                                System.out.println("->Input the passcode");
                                String passcode = user_input.nextLine();//case sensitive because the passcode uses capitalized letters
                                // if passcode is correct
                                while (livingroom.unlock(passcode)) {
                                    exitPrompt();
                                    String exit_decision = user_input.nextLine().toLowerCase();
                                    if (exit_decision.equals("exit the room")) {
                                        person.enter(2);//user's position changes to 2, which is the living room
                                        stillSearching = false;
                                        break;
                                    } else if (exit_decision.equals("check other things in the room")) {
                                        stillSearching = true;
                                        break;
                                    } else{
                                        InvalidInput();//invalid input
                                        System.out.println();
                                    }
                                }if(!livingroom.unlock(passcode)) {
                                    System.out.println("->Unlock failed!");
                                    stillSearching = true;
                                    count -= 1;
                                    System.out.println("->You have " + count + " more tries!");
                                }
                                break;
                            //When the user inputs help, print out the instruction to guide the user to the next step of the game
                            case "help":
                                System.out.println(
                                        "->Type a name of the item in the room to start searching. For example, type 'closet'.");
                                System.out.println();
                                break;
                            //When the user inputs quit, print out the message to end the game
                            case "quit":
                                goodbye();
                                break;
                            //When the user inputs unexpected message, prints a defualt invalid input message 
                            default:
                                InvalidInput();
                                System.out.println();
                            }
                        }
                        if (count == 0) {// Ran out of unlock attempts
                            System.out.println("->You ran out of tries! You are locked in the room!");
                            goodbye();
                        }
                    }
                }

                // Living Room
                while (person.position == 2) {
                    // when position equals 2, the character is in Living
                    stillSearching = true;
                    
                    System.out.println(
                            "You have unlocked bathroom and bedroom! Type 'Bathroom' or 'Bedroom' if you want to go back to one of the rooms. Hit enter to continue!");
                    String Room_name = user_input.nextLine();
                    // Once living room is unlocked, free to go back to either two previous rooms
                    if (Room_name.equals("Bathroom")) {
                        person.enter(0);

                    } else if (Room_name.equals("Bedroom")) {
                        person.enter(1);

                    } else {// Begin searching in the living room
                        System.out.println("=======================================================");
                        System.out.println("You saw there is a lock on the door. You need to input a 4 digits code.");
                        System.out.println(livingroom);
                        livingroom.examine();

                        int attempt = 3;// initialize counter for the max amount of unlock attempts
                        while (stillSearching && attempt > 0) {
                            if (stillSearching) {
                                welcomeMessage("living room");
                                livingroom.examine();
                                System.out.println();
                                String object = user_input.nextLine().toLowerCase();
                                if (object.equals("go back")){
                                    break;
                                }
                                switch(object){
                                //When user checks the sofa, they will find a candle and be asked whether they would like to pick it up.
                                case "sofa":
                                    livingroom.checkSofa();
                                    if(livingroom.candle_status){
                                        System.out.println("->Do you want to pick it up? (yes/no)");
                                        String decision_candle = user_input.nextLine().toLowerCase();
                                        if (decision_candle.equals("yes")) {
                                            person.pickup("candle");
                                            if (person.haveItem("candle")){
                                                livingroom.setCandle_status(false);
                                            }else{
                                                livingroom.setCandle_status(true);
                                            }
                                            System.out.println();
                                        } else if (decision_candle.equals("no")) {
                                            System.out.println("->Okay.");
                                            System.out.println();
                                        } else {//When the user inputs unexpected message, print a default invalid input message.
                                            InvalidInput();
                                            System.out.println();
                                        }
                                    }
                                    break;
                                //When user checks the carpet, they will find a set of keychains for the car and be asked whether they would like to pick it up.
                                case "carpet":
                                    livingroom.checkCarpet();
                                    if(livingroom.keychain_status){
                                        System.out.println("->Do you want to pick it up? (yes/no)");
                                        String decision_keychains = user_input.nextLine().toLowerCase();
                                        if (decision_keychains.equals("yes")) {
                                            person.pickup("key chains");
                                            if (person.haveItem("key chains")){
                                                livingroom.setKeychain_status(false);
                                            }else{
                                                livingroom.setKeychain_status(true);
                                            }
                                            System.out.println();
                                            livingroom.setKeychain_status(false);

                                        } else if (decision_keychains.equals("no")) {
                                            System.out.println("->Okay.");
                                            System.out.println();
                                        } else {//When the user inputs unexpected message, print a default invalid input message.
                                            InvalidInput();
                                            System.out.println();
                                        }
                                    }
                                    break;

                                //When user checks the fireplace, they will find a message from the ashes about the clues to unlock the front door.
                                case "fire place":
                                    livingroom.checkFireplace();
                                    System.out.println();
                                    break;
                                //When user checks the floor lamp, it does not light up but it will turn on the fire place.
                                case "floor lamp":
                                    livingroom.Floorlamp();
                                    System.out.println(
                                            "->What do you want to do next? (burn the candle/shut off the fireplace)");
                                    String decision_floorlamp = user_input.nextLine().toLowerCase();
                                    if (decision_floorlamp.equals("burn the candle")) {
                                        person.burnCandle();
                                        System.out.println();
                                    } else if (decision_floorlamp.equals("shut off the fireplace")) {
                                        livingroom.ShutOffFireplace();
                                        System.out.println();
                                    } else if (decision_floorlamp.equals(" ")){
                                        break;
                                    }else {//When the user inputs unexpected STARmessage, print a default invalid input message.
                                        InvalidInput();
                                        System.out.println();
                                    }
                                    break;
                                //When user checks the tv, the tv will be playing their favroite show and will be asked whether they would like to switch a channel or turn off the tv.
                                case "tv":
                                    livingroom.turnOnOff_TV("on");
                                    String decision_TV = user_input.nextLine().toLowerCase();
                                    if (decision_TV.equals("yes")) {//game ends if user keep on watching the tv
                                        System.out.println("->You wasted too long binge watching TV, Mission Failed!");
                                        goodbye();
                                    } else if (decision_TV.equals("switch a channel")) {
                                        livingroom.switchChannel();
                                        System.out.println();

                                    } else if (decision_TV.equals("stop watching and turn off the tv")) {
                                        livingroom.turnOnOff_TV("off");
                                        System.out.println();
                                        stillSearching = true;
                                    }else{//When the user inputs unexpected message, print a default invalid input message.
                                        InvalidInput();
                                        System.out.println();
                                    }
                                    break;
                                //When user inputs unlock, it will prompt the user to input the passcode
                                case "unlock":
                                    System.out.println("->Input the passcode");
                                    String passcode = user_input.nextLine();
                                    livingroom.exitHouse(passcode);

                                    //once they unlock the house, it prompt the user to select the right car key.
                                    if (!livingroom.getlocked_house()) {
                                        person.position = 3;// Outside the house, position equals 3
                                        System.out.println(
                                                "In front of the house, there is a Porsche car waiting for you.");
                                        if (person.haveItem("key chains")) {//only prompt the user to identify the car key if they picked it up from the living room
                                            System.out.println("->Which car key is the right one?");
                                            String decision_car = user_input.nextLine();//case sensitive because the carkey is capitalized
                                            if (decision_car.equals("E")) {
                                                System.out.println(
                                                        "->You used the car key to drive to the court, successfully identified the suspect. Mission Complete! Thank you for your hard work!");
                                                goodbye();
                                            } else {//if the user unsuccessfully identified the car key, the game fails.
                                                System.out.println(
                                                        "->Unfortunately, you didn't have to car key to drive to court. You walked for an hour and you missed the court session. Mission Failed.");
                                                stillSearching = false;
                                                goodbye();
                                            }
                                        } else {
                                            System.out.println("->You don't have a key to drive the car.");
                                        }
                                    } else {
                                        System.out.println("->Unlock failed!");
                                        stillSearching = true;
                                        attempt -= 1;
                                        System.out.println("->You have " + attempt + " more tries!");
                                    }
                                    break;
                                //When the user inputs help, print out the instruction to guide the user to the next step of the game
                                case "help":
                                    System.out.println(
                                            "->Type a name of the item in the room to start searching. For example, type 'sofa'.");
                                    System.out.println();
                                    break;
                                 //When the user inputs quit, print out the message to end the game
                                case "quit":
                                    goodbye();
                                    break;
                                //When the user inputs unexpected message, print a default invalid input message.
                                default:
                                    InvalidInput();
                                    System.out.println();
                                }
                            }
                        }
                        if (attempt == 0) {// Ran out of unlock attempts
                            System.out.println("You run out of tries! You are locked in the room!");
                            goodbye();
                        }

                    }
                }
            }
            // close scanner
            user_input.close();
        }
    }
}