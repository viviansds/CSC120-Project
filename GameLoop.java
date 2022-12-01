import java.util.Scanner;
public class GameLoop {
    public static void main(String[] arguments) {
        //bedroom section
        Bedroom bedroom = new Bedroom("Bedroom", true, "key");
        System.out.println(bedroom);
        bedroom.examine();
        for (int i = 0; i < 5; i++) {
        Scanner check = new Scanner(System.in);
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
            Scanner status = new Scanner(System.in);
            System.out.println("Input On/Off to change the status of the lamp");
            String OnOff = status.nextLine();
            if (OnOff.equals("On")){
                bedroom.turn_on_lamp();
            }else if (OnOff.equals("Off")){
                bedroom.turn_off_lamp();
            }
    
        
        }
    }
        }
    
    
        
        // try (Scanner input = new Scanner(System.in)){
        // }
    }


