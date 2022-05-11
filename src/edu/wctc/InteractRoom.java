package edu.wctc;

import edu.wctc.RoomStrategies.InteractableStrategy;

public class InteractRoom extends Room implements InteractableStrategy {


    public InteractRoom(String name) {
        super(name);
    }

    //@Override
    public String getDescription() {
        return "As you enter into the central room, you see the reason why the ship has no power. " +
                "\n The ships reactor is heavily damaged, and two large boxy objects are floating around it. " +
                "\n You'll have to pull them into the light to observe the objects better.";
    }

    //@Override
    public String interact(Player player) {
        return "As you move the objects into the light, you realize what they are. " +
                "\n The crewmembers. " +
                "\n At least, whats left of them. Both of their bodies have been ripped in half as if by a powerful explosion. " +
                "\n It seems the SolarTech Reactor in the ship melted down. Unfortunate.";
    }
}
