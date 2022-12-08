import java.util.Scanner;
public class GameLoop {
    public static void main(String[] arguments) {
        // This is a "flag" to let us know when the game loop should end
        boolean stillPlaying = true;
        //This is a "flag" to let us know when the person want to stop searching
        boolean stillSearching=true;
    
        // We'll use this to get input from the user.
        Scanner user_input = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";
        
        // This could be replaced with a more interesting opening
        System.out.println("****************************");
        System.out.println("WELCOME TO THE ESCAPE ROOM");
        System.out.println("****************************");

        // Instructions are sometimes helpful
        System.out.println("Ready to play? Enter 'START'");
        userResponse = user_input.nextLine();
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");

        //change the userinput to uppercase

        //START GAME
        if (userResponse.equals("START")){
             //Background Story
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Today is December 21st.");
            System.out.println("You are a secret FBI agent and your last assigned mission of this year is to appear in court and identify the suspect at noon today.");
            System.out.println("This morning, you were walking down the street, and out of nowhere, the people from the criminal gang kidnapped you.");
            System.out.println("After a long while, you woke up in a bath tub around 10:30 and found yourself locked inside a bathroom of an unknown house.");
            System.out.println("All the rooms inside the house are locked and it is your job to use the clues around you to unlock the door and be at the court in time.");
            System.out.println("Good Luck!");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            
            //Initialize rooms and characters
            Bathroom Bathroom= new Bathroom("Bathroom",false,"key");
            Bedroom bedroom = new Bedroom("Bedroom", true, "passcode","key");
            Livingroom livingroom = new Livingroom("Living Room",true,"entry_code");
            Character person = new Character("You");
            //Start playing loop
            while (stillPlaying){

                //Bathroom
                if (person.position==0){
                    System.out.println(Bathroom);
                    String key = "key";
                    Bathroom.examine();
                    while (stillSearching) {
                        //Scanner Bathroom_scanner = new Scanner(System.in);
                            System.out.println("=======================================================");
                            System.out.println("Which object do you wanna check?");
                            System.out.println("Type 'unlock' if you are ready to try to use the key!");
                            System.out.println("Type 'help' if you need additional tip to proceed.");
                            System.out.println("Type 'quit' if you want to end the game.");
                            System.out.println("=======================================================");
                            System.out.println();
                            //String object = Bathroom_scanner.nextLine();
                            String object = user_input.nextLine().toLowerCase();
                            
                            //Check Objects in the room
                            if (object.equals("toilet")){
                                Bathroom.Toilet();
                                System.out.println();

                            }else if (object.equals("bathtub")){
                                Bathroom.Bathtub();
                                System.out.println();

                            }else if (object.equals("mirror")){
                                Bathroom.Mirror();
                                //Scanner Mirror_Scanner = new Scanner(System.in);
                                    System.out.println("->You remembered fog can make some stain more obvious. Are you going to try that? (yes/no)");
                                    String decision_mirror = user_input.nextLine();
                                if(decision_mirror.equals("yes")){
                                    System.out.println("->Words appeared on the mirror: Don't lose track of time. Find the key.");
                                    System.out.println();
                                }
                                // Mirror_Scanner.close();
            
                            }else if (object.equals( "closet")){
                                Bathroom.Closet();
                                if(Bathroom.Bag_in_closet){
                                    //Scanner Closet_Scanner = new Scanner(System.in);
                                    System.out.println("->Do you want to carry it? (yes/no)");
                                    String decision_bag = user_input.nextLine();
                                    if (decision_bag.equals("yes")){
                                        System.out.println("->You got the bag and were able to pick up things.");
                                        System.out.println();
                                        person.setHaveBag();
                                        Bathroom.setBag_in_closet();
                                    }else{
                                        System.out.println("->Okay.");
                                        System.out.println();
                                    }
                                }
                                // Closet_Scanner.close();
                                
                            }else if (object.equals("shelves")){
                                if(person.haveKey){
                                    Bathroom.Shelves();
                                }else{
                                    Bathroom.Shelves();
                                    //Scanner shovel_Scanner = new Scanner(System.in);
                                    System.out.println("->Do you want to use the shovel to dig the plant and see what will happen? (yes/no)");
                                    String decision_shovel = user_input.nextLine();
                                    if (decision_shovel.equals("yes")){
                                        person.setHaveKey();
                                        System.out.println("->God job! You found a key in the plant.");
                                       // Scanner Shelves_Scanner = new Scanner(System.in);
                                            System.out.println("->Do you want to use them or not? (yes/no)");
                                            String decision_key = user_input.nextLine();
                                            if (decision_key.equals("yes")){
                                                bedroom.unlock(key);
                                                System.out.println("->You unlocked the door. What do you want to do next? (exit the room / check other things in the room)");
                                                //String exit_decision = Bathroom_scanner.nextLine();
                                                String exit_decision = user_input.nextLine();
                                                if(exit_decision.equals("exit the room")){
                                                    person.enter(1);
                                                    stillSearching = false;
                                                }else if (exit_decision.equals("check other things in the room")){
                                                    stillSearching = true;
                                                }
                                            } else if(decision_key.equals("no")){
                                                System.out.println("->You were stuck in the room and couldn't unlock to go outside. Mission failed.");
                                                System.exit(0);
                                            }  
                                    // Shelves_Scanner.close(); 
                                    }
                                } 
                            }else if (object.equals("unlock")){
                                if(person.haveKey){
                                    System.out.println("->You unlocked the door.");
                                    person.enter(1);
                                    stillSearching = false;
                                }else{
                                    System.out.println("->The bathroom is locked. Try to find a key inside this room.");
                                    System.out.println();
                                }

                            }else if(object.equals("help")){
                                System.out.println("->Type a name of the item in the room to start searching. For example, type 'closet'.");
                                System.out.println();
                            
                            }else if(object.equals("quit")){
                                System.out.println("->Thank you for playing, bye!");
                                System.exit(0);
                            
                            }else{
                                System.out.println("->Invalid Object, please select one inside the room.");
                                System.out.println();
                            }
                    }
                }
                //bedroom section
                else if(person.position == 1){
                    System.out.println("You have unlocked the bedroom! Type 'Bathroom' if you want to go back to bathroom. Hit enter to continue!");
                    String bathroom_name1 = user_input.nextLine();
                    System.out.println("You saw there is a lock on the door. You can either input letters or numbers to the lock, and it requires six digits. ");
                    System.out.println(bedroom);
                    bedroom.examine();
                    stillSearching = true;

                    if(bathroom_name1.equals("Bathroom")){
                        person.enter(0);
                    }else{//start searching in bedroom
                        int count = 3;
                        while (stillSearching && count > 0) {
                                //Scanner Bedroom_Scanner = new Scanner(System.in);
                                System.out.println("=======================================================");
                                System.out.println("Which object do you wanna check?");
                                System.out.println("Type 'unlock' if you are ready to try to use the key!");
                                System.out.println("Type 'help' if you need additional tip to proceed.");
                                System.out.println("Type 'quit' if you want to end the game.");
                                System.out.println("=======================================================");
                                System.out.println();
                                String object = user_input.nextLine().toLowerCase();

                                //Check Objects in the room
                                if (object.equals("bed")){
                                    bedroom.Bed();
                                    System.out.println();

                                }else if (object.equals("closet")){
                                    bedroom.Closet();
                                    System.out.println();

                                }else if (object.equals("drawers")){
                                    bedroom.Drawers();
                                    System.out.println();

                                }else if (object.equals("curtain")){
                                    bedroom.Curtains();
                                    System.out.println();

                                }else if (object.equals( "lamp")){
                                    //Scanner Lamp_Scanner = new Scanner(System.in);
                                    System.out.println("->Input On/Off to change the status of the lamp");
                                    String OnOff = user_input.nextLine().toLowerCase();
                                    if (OnOff.equals("on")){
                                        bedroom.turn_on_lamp();
                                    }else if (OnOff.equals("off")){
                                        bedroom.turn_off_lamp();
                                    }

                                }else if (object.equals("unlock")){
                                    System.out.println("->Input the passcode");
                                    //Scanner password = new Scanner(System.in);
                                    String passcode = user_input.nextLine();
                                    //if passcode is correct
                                    if(livingroom.unlock(passcode)){
                                        System.out.println("->You unlock the door. What do you want to do next? (exit the room / check other things in the room) ");
                                        String exit_decision = user_input.nextLine();
                                        if(exit_decision.equals("exit the room")){
                                            person.enter(2);
                                            stillSearching = false;
                                        }else if (exit_decision.equals("check other things in the room")){
                                            stillSearching = true;
                                        }
                                    }else{
                                    System.out.println("->Unlock failed!");
                                    stillSearching = true;
                                    count = count -1;
                                    System.out.println("->You have " + count + " more tries!");
                                    }
                                
                                }else if(object.equals("help")){
                                    System.out.println("->Type a name of the item in the room to start searching. For example, type 'closet'.");
                                    System.out.println();
                                
                                }else if(object.equals("quit")){
                                    System.out.println("->Thank you for playing, bye!");
                                    System.exit(0);

                                }else{
                                    System.out.println("->Invalid Object, please select one inside the room.");
                                    System.out.println();
                                }

                        }if(count==0){//Ran out of unlock attempts
                            System.out.println("->You ran out of tries! You are locked in the room!");
                            System.exit(0);
                        }
                    }
                }

                //Living Room
                else if(person.position == 2){
                    stillSearching = true;
                    //Scanner twoRooms_scanner = new Scanner(System.in);
                    System.out.println("You have unlocked bathroom and bedroom! Type 'Bathroom' or 'Bedroom' if you want to go back to one of the rooms. Hit enter to continue!");
                    String Room_name = user_input.nextLine();
                    //Once living room is unlocked, free to go back to either two previous rooms
                    if(Room_name.equals("Bathroom")){
                        person.enter(0);

                    }else if(Room_name.equals("Bedroom")){
                        person.enter(1);
                
                    }else{//Begin searching in the living room
                        System.out.println("You saw there is a lock on the door. You need to input a 4 digits code.");
                        System.out.println(livingroom);
                        livingroom.examine();
        
                        int attempt=3;//counter for the max amount of unlock attempts
                        while (stillSearching && attempt>0){
                                if(stillSearching){
                                    //Scanner LR_scanner = new Scanner(System.in);
                                    System.out.println("=======================================================");
                                    System.out.println("Which object do you wanna check?");
                                    System.out.println("Type 'unlock' if you are ready to try to use the key!");
                                    System.out.println("Type 'help' if you need additional tip to proceed.");
                                    System.out.println("Type 'quit' if you want to end the game.");
                                    System.out.println("=======================================================");
                                    System.out.println();
                                    String object = user_input.nextLine().toLowerCase();
                                        if(object.equals("sofa")){
                                            livingroom.CheckSofa();
                                            //Scanner Sofa_Scanner = new Scanner(System.in);
                                            System.out.println("->Do you want to pick it up? (yes/no)");
                                            String decision_candle = user_input.nextLine();
                                            if (decision_candle.equals("yes")){
                                                person.pickup("candle");
                                                System.out.println();
                                                person.haveBag = true;
                                                System.out.println();

                                            }else{
                                                System.out.println("->Okay.");
                                                System.out.println();
                                            }

                                        }else if(object.equals("carpet")){
                                            livingroom.CheckCarpet();
                                            System.out.println("->Do you want to pick it up? (yes/no)");
                                            //Scanner Carpet_Scanner = new Scanner(System.in);
                                            String decision_keychains = user_input.nextLine();
                                            if (decision_keychains.equals("yes")){
                                                person.pickup("key chains");
                                                System.out.println();

                                            }else{
                                                System.out.println("->Okay.");
                                                System.out.println();
                                            }

                                        }else if(object.equals("fire place")){
                                            livingroom.CheckFireplace();
                                            System.out.println();

                                        }else if(object.equals("floor lamp")){
                                            livingroom.Floorlamp();
                                            System.out.println("->What do you want to do next? (burn the candle/shut off the fireplace)");
                                            //Scanner Floorlamp_Scanner = new Scanner(System.in);
                                            String decision_floorlamp = user_input.nextLine();
                                            if (decision_floorlamp.equals("burn the candle")){
                                                person.BurnCandle();
                                                System.out.println();

                                            }else if (decision_floorlamp.equals("shut off the fireplace")){
                                                livingroom.ShutOffFireplace();
                                                System.out.println();

                                            }

                                        }else if(object.equals("tv")){
                                            livingroom.TurnOnTV(); 
                                            //Scanner TV_Scanner = new Scanner(System.in);
                                            String decision_TV = user_input.nextLine();
                                            if (decision_TV.equals("yes")){
                                                System.out.println("->You wasted too long binge watching TV, Mission Failed!");
                                                System.exit(0);
                                            }else if(decision_TV.equals("switch a channel")){
                                                System.out.println("---------------------------------------------------------------------------------");
                                                System.out.println("Hello Secret Agent, my name is Yosef D. Harrison. By the time you reached this point of the gane, you are almost there. I have been a spy in this criminal gang C.Crew for 8 years unde the code name 35.");
                                                System.out.println("My job is to help secret agent like you to get out. I have a strong confidence that you can escape this trap and you will uphold the justice that we always wanted for the world.");
                                                System.out.println("Outside the house, I have prepared you a car to be in court in time. This house is quite far, you won't be able to get to the court without a car under an hour.");
                                                System.out.println("Time's running out. We'll meet each other in the bright future.");
                                                System.out.println("---------------------------------------------------------------------------------");
                                                System.out.println();

                                            }else if(decision_TV.equals("stop watching and turn off tv")){
                                                livingroom.TurnOffTV();
                                                System.out.println();
                                                stillSearching=true;
                                            }

                                        }else if(object.equals("unlock")){
                                            System.out.println("->Input the passcode");
                                            //Scanner password_scanner = new Scanner(System.in);
                                            String passcode = user_input.nextLine();
                                            livingroom.exitHouse(passcode);

                                            //Outside the house
                                            person.position = 3;
                                            if(!livingroom.getlocked_house()){
                                                System.out.println("In front of the house, there is a Porsche car waiting for you.");
                                                if (person.haveItem("key chains")){
                                                    System.out.println("->Which car key is the right one?");
                                                    //Scanner Car_Scanner = new Scanner(System.in);
                                                    String decision_car = user_input.nextLine();
                                                    if (decision_car.equals("E")){
                                                        System.out.println("->You used the car key to drive to the court, successfully identified the suspect. Mission Complete! Thank you for your hard work!");
                                                        System.exit(0);
                                                        
                                                    }else{
                                                        System.out.println("->Unfortunately, you didn't have to car key to drive to court. You walked for an hour and you missed the court session. Mission Failed.");
                                                        stillSearching=false;
                                                        System.exit(0);
                                                    }
                                                }else{
                                                    System.out.println("->You don't have a key to drive the car.");
                                                }
                                            
                                            }else{
                                            System.out.println("->Unlock failed!");
                                            stillSearching = true;
                                            attempt -=1;
                                            System.out.println("->You have " + attempt + " more tries!");
                                            }
                                        }else if(object.equals("help")){
                                            System.out.println("->Type a name of the item in the room to start searching. For example, type 'sofa'.");
                                            System.out.println();
                                        
                                        }else if(object.equals("quit")){
                                            System.out.println("->Thank you for playing, bye!");
                                            System.exit(0);
        
                                        }else{
                                            System.out.println("Invalid Object, please select one inside the room.");
                                            System.out.println();
                                        }
                                }
                        }//Ran out of unlock attempts
                        System.out.println("You run out of tries! You are locked in the room!");
                        System.exit(0);
                        
                        
                    }
                }
            }
        //close scanner
        user_input.close();  
        }
    }      
}