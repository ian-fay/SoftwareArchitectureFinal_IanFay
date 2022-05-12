package edu.wctc;

import edu.wctc.RoomStrategies.*;

public class Maze {
    private Room currentRoom;
    private Player player;
    public boolean isFinished;
    //Make this private and update the code to comply with the adjustment

    //This is a singleton.
    private static Maze instance;
    public static Maze buildMaze() {
        if(instance == null) {
            instance = new Maze();
        }
        return instance;
    }
    private Maze() {

        Room entryRoom = RoomBuilder.getRoom("Entry Airlock", new StartRoom(), "This is the room you entered the ship in. The Airlock has sealed behind you. You will have to find another way out.");
        Room emptyRoom1 = RoomBuilder.getRoom("Empty Room", new EmptyRoom(), "This room is simply metal floors and walls covered in broken machinery.");
        Room emptyRoom2 = RoomBuilder.getRoom("Empty Room", new EmptyRoom(), "This room is simply metal floors and walls covered in broken machinery.");
        Room emptyRoom3 = RoomBuilder.getRoom("Empty Room", new EmptyRoom(), "This room is simply metal floors and walls covered in broken machinery.");
        Room emptyRoom4 = RoomBuilder.getRoom("Empty Room", new EmptyRoom(), "This room is simply metal floors and walls covered in broken machinery.");
        Room emptyRoom5 = RoomBuilder.getRoom("Empty Room", new EmptyRoom(), "This room is simply metal floors and walls covered in broken machinery.");
        Room interactRoom = RoomBuilder.getRoom("Windowed Room", new InteractRoom(), "As you enter into the central room, you see the reason why the ship has no power. " +
                "\n The ships reactor is heavily damaged, and two large boxy objects are floating around it. " +
                "\n You'll have to pull them into the light to observe the objects better.");
        Room lootRoom = RoomBuilder.getRoom("Blackbox Room", new LootRoom(), "Adjacent to the reactor room is the Monitoring Station. Most of the screens are cracked and broken, and what little power the ship still has illuminates only one screen." +
                "\n BLACKBOX INTEGRITY: 93%. Sitting next to the screen is the smooth black sphere covered in circuit patterns. Its not even scratched." +
                "\n These things were built to last after all.");
        Room exit1 = RoomBuilder.getRoom("Exit Airlock",new ExitRoom(), "This is the airlock which will take you out of the maze.");

        entryRoom.setNorth(emptyRoom1);
        emptyRoom1.setSouth(entryRoom);
        emptyRoom1.setNorth(emptyRoom2);
        emptyRoom1.setWest(emptyRoom3);

        emptyRoom2.setSouth(emptyRoom1);
        emptyRoom2.setNorth(interactRoom);

        emptyRoom3.setEast(emptyRoom1);

        interactRoom.setSouth(emptyRoom2);
        interactRoom.setNorth(lootRoom);
        interactRoom.setSouth(emptyRoom2);

        lootRoom.setNorth(emptyRoom4);
        lootRoom.setSouth(interactRoom);

        emptyRoom4.setNorth(exit1);
        emptyRoom4.setSouth(lootRoom);
        emptyRoom4.setEast(emptyRoom5);
        emptyRoom5.setWest(emptyRoom4);

        exit1.setSouth(emptyRoom1);

        currentRoom = entryRoom;

        isFinished = false;
        player = new Player();

    }

    public String doAction(Player player) {
        return currentRoom.doAction(player);
    }

    public boolean Move(char Direction) {

        if (currentRoom.isValidDirection(Direction)) {
            currentRoom = currentRoom.getAdjoiningRoom(Direction);
            return true;

        } else {
            return false;

        }

    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

//    public String exitCurrentRoom() {
//        if(currentRoom instanceof ExitableStrategy) {
//            isFinished = true;
//            return ((ExitableStrategy) currentRoom).exit(player);
//        } else {
//            return "You cannot leave the Maze here.";
//
//        }
//    }
//
//    public String lootCurrentRoom() {
//        if(currentRoom instanceof LootableStrategy) {
//            return ( currentRoom).loot(player);
//        } else {
//            return "There is nothing to loot here.";
//        }
//    }
//
//    public String interactWithCurrentRoom() {
//        if(currentRoom instanceof InteractableStrategy) {
//            return ( currentRoom).interact(player);
//        } else {
//            return "You cannot interact with anything in the room here.";
//        }
//    }

    public boolean isFinished() {
        return isFinished;
    }

}


