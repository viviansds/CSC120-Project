import java.util.ArrayList; // import the ArrayList class

public class Character {
    public String name;
    public int position;//track the person's location, 0=bathroom,1=bedroom, 2= living room, 3=outside
    boolean haveBag = false;
    boolean haveKey = false;
    ArrayList<String> Bag = new ArrayList<String>();

    public Character(String name){
        this.name = name;
        this.position = 0;
    }

    public void enter(int room_num) {
        if (position!= room_num){
            if (room_num==0){
                position = 0;
                System.out.println("->You are now inside the bathroom.");
            }else if (room_num==1){
                position = 1;
                System.out.println("->You are now inside the bedroom");
            }else if(room_num==2){
                position = 2;
                System.out.println("->You are now inside the living room");
            }
        }else{
            System.out.println("->You are already inside the room.");
        }
    }

    public void pickup(String item){
        if (haveBag){
        System.out.println("->You just pick up the " + item);
        Bag.add(item);
        System.out.println(Bag);
        }else{
            System.out.println("->You can't have this item because you don't have a bag.");
        }
    }


    public boolean setHaveBag(){
        haveBag=true;
        return haveBag;
    }

    public boolean setHaveKey(){
        haveKey = true;
        return haveKey;
    }
    
    public void BurnCandle(){
        if(haveItem("candle")){
            Bag.remove("candle");
            System.out.println("Bag has"+Bag);
            System.out.println("As Candle start burning, it started to melt and a note came out of the wax. The message wrote:");
            System.out.println("I'm the beginning of the end, the end of every place. I'm the beginning of eternity, the end of time and space. What am I?. If you know what I am, use me to find the right key to drive the car.");
        }else{
            System.out.println("You don't have a candle in your bag yet");
        }
        
    }
    public boolean haveItem(String item){
        boolean haveItem=false;
        if (Bag.contains(item)){
            haveItem=true;
        }else{
            haveItem=false;
        }return haveItem;
    }
}

