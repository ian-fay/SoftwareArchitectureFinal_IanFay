package edu.wctc;

import edu.wctc.RoomStrategies.LootableStrategy;

public class LootRoom extends Room implements LootableStrategy {

    public LootRoom(String name) {
        super(name);
    }

    //@Override
    public String getDescription() {
        return "Adjacent to the reactor room is the Monitoring Station. Most of the screens are cracked and broken, and what little power the ship still has illuminates only one screem. " +
                "\n BLACKBOX INTEGRITY: 93%. Sitting next to the screen is the smooth black sphere covered in circuit patterns. Its not even scratched." +
                "\n These things were built to last after all.";
    }

    //@Override
    public String loot(Player player) {
        player.addToInventory("U.S.S Gutpunch Blackbox");
        player.addToScore(100);
        return "You remove the Blackbox and add it to your inventory.";
    }
}
