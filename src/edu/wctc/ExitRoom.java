package edu.wctc;

import edu.wctc.RoomStrategies.ActionStrategy;

public class ExitRoom implements ActionStrategy {

    //@Override

    public String doAction(Player player) {

        return "You left the maze.";
    }
}
