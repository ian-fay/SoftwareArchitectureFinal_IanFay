package edu.wctc;

import edu.wctc.RoomStrategies.ActionStrategy;

public class EmptyRoom implements ActionStrategy {

    public String doAction(Player player) {
        return "There is nothing to do in this room but continue deeper.";
    }
}
