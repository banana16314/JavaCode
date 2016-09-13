package Castle;

import java.util.HashMap;
import java.util.Scanner;
//import java.util.logging.Handler;

public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers=new HashMap<String, Handler>();

    public Game() 
    {
        handlers.put("go", new HandlerGo(this) );
        handlers.put("help", new HandlerHelp(this));
        handlers.put("bye", new HandlerBye(this));
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("outside");
        lobby = new Room("in lobby");
        pub = new Room("in pub");
        study = new Room("in study");
        bedroom = new Room("in bedroom");
        
        //	初始化房间的出口
        outside.setExit("east",lobby);
        outside.setExit("west",pub);
        outside.setExit("south",study);
        lobby.setExit("west",outside);
        pub.setExit("east",outside);
        study.setExit("north",outside);
        study.setExit("east",bedroom);
        bedroom.setExit("west", study);
        lobby.setExit("up",pub);
        pub.setExit("down",lobby);
        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Castal Game");
        System.out.println("It is very Boring!!");
        System.out.println("Need help? Type 'help' ");
        System.out.println();
        showPrompt();
    }

    // 以下为用户命令


    public void goRoom(String direction)
    {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("No doors");
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }

    public void showPrompt(){
        System.out.println("Now you are " + currentRoom);
        System.out.print("Exits: ");
         System.out.print(currentRoom.getExitDesc());
        System.out.println();
    }
    public void play(){
        Scanner in = new Scanner(System.in);
        while ( true ) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler=handlers.get(words[0]);
            String value="";
            if(words.length > 1){
                value=words[1];
            }
            if (handler != null){
                handler.doCmd(value);
                if (handler.isBye()){
                    break;
                }
            }
         /*   if ( words[0].equals("help") ) {
                printHelp();
            } else if (words[0].equals("go") ) {
                goRoom(words[1]);
            } else if ( words[0].equals("bye") ) {
                break;
            }*/
        }
        in.close();
    }

	public static void main(String[] args) {
		Game game = new Game();
		game.printWelcome();
        game.play();
        System.out.println("Thanks for Playing! BYE!");
	}

}
