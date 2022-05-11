package edu.wctc;

public class EmptyRoom extends Room {

    public EmptyRoom(String name) {
        super(name);
    }

    public String getDescription() {
        return "This room is simply metal floors and walls covered in broken machinery.";
    }
}
