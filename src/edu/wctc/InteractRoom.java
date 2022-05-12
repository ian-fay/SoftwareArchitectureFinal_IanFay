package edu.wctc;

import edu.wctc.RoomStrategies.ActionStrategy;

public class InteractRoom implements ActionStrategy {

    public String doAction(Player player) {
        return "As you move the objects into the light, you realize what they are. " +
                "\n The crewmembers. " +
                "\n At least, whats left of them. Both of their bodies have been ripped in half as if by a powerful explosion. " +
                "\n It seems the SolarTech Reactor in the ship melted down. Unfortunate.";
    }
}
