package edu.wctc;

import edu.wctc.RoomStrategies.ExitableStrategy;

public class ExitRoom extends Room implements ExitableStrategy {


    public ExitRoom(String name) {
        super("Exit Airlock");
    }

    //@Override
    public String getDescription() {
        return "This airlock will take you out of the ship [Leave].";
    }

    //@Override
    public String exit(Player player) {

        return "You left the maze.";
    }
}
