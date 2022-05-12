package edu.wctc;

import edu.wctc.RoomStrategies.ActionStrategy;

public class RoomBuilder {

public static Room getRoom(String name, ActionStrategy actionStrategy, String description) {
    Room theRoom = new Room(name,actionStrategy,description);
    return theRoom;
}

}
