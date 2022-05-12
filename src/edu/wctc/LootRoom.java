package edu.wctc;

import edu.wctc.RoomStrategies.ActionStrategy;

public class LootRoom implements ActionStrategy {

    public String doAction(Player player) {
        player.addToInventory("U.S.S Gutpunch Blackbox");
        player.addToScore(100);
        return "You remove the Blackbox and add it to your inventory.";
    }

}
