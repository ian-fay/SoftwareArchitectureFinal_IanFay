package edu.wctc;

import edu.wctc.RoomStrategies.*;

public class Maze {
    private Room currentRoom;
    private Player player;
    public boolean isFinished;
    //Make this private and update the code to comply with the adjustment
    private static Maze instance;
    public static Maze buildMaze() {
        if(instance == null) {
            instance = new Maze();
        }
        return instance;
    }
    private Maze() {

        Room entryRoom = new StartRoom("Entry Airlock");
        Room emptyRoom1 = new EmptyRoom("Empty Room");
        Room emptyRoom2 = new EmptyRoom("Empty Room");
        Room emptyRoom3 = new EmptyRoom("Empty Room");
        Room emptyRoom4 = new EmptyRoom("Empty Room");
        Room emptyRoom5 = new EmptyRoom("Empty Room");
        Room interactRoom = new InteractRoom("Windowed Room");
        Room lootRoom = new LootRoom("Blackbox Room");
        Room exit1 = new ExitRoom("Exit Airlock");

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

    public String exitCurrentRoom() {
        if(currentRoom instanceof ExitableStrategy) {
            isFinished = true;
            return ((ExitableStrategy) currentRoom).exit(player);
        } else {
            return "You cannot leave the Maze here.";

        }
    }

    public String lootCurrentRoom() {
        if(currentRoom instanceof LootableStrategy) {
            return ((LootableStrategy) currentRoom).loot(player);
        } else {
            return "There is nothing to loot here.";
        }
    }

    public String interactWithCurrentRoom() {
        if(currentRoom instanceof InteractableStrategy) {
            return ((InteractableStrategy) currentRoom).interact(player);
        } else {
            return "You cannot interact with anything in the room here.";
        }
    }

    public boolean isFinished() {
        return isFinished;
    }

}


