package edu.wctc;

public class StartRoom extends Room{
    public StartRoom(String name) {
        super(name);
    }

    //@Override
    public String getDescription() {
        return "This is the room you entered the ship in. The Airlock has sealed behind you. You will have to find another way out.";
    }
}
