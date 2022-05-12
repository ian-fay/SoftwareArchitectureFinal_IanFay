package edu.wctc;

import edu.wctc.RoomStrategies.ActionStrategy;

public class Room {
    private String name;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room up;
    private Room down;
    ActionStrategy theAction;
    private String description;

    public Room(String name, ActionStrategy actionStrategy, String description) {
        this.name = name;
        this.theAction = actionStrategy;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription()  {
        return description;
    }

    public String doAction(Player player) {
        return theAction.doAction(player);
    }

    public String getExits() {
        String output = "Exits are:";
        if(north != null) {
            output += "n|";
        }
        if(south != null) {
            output += "s|";
        }
        if(east != null) {
            output += "e|";
        }
        if(west != null) {
            output += "w|";
        }
        return output;
    }


    public Room getAdjoiningRoom(char Direction) {

        return switch (Direction) {
            case 'n' -> north;
            case 's' -> south;
            case 'e' -> east;
            case 'w' -> west;
            case 'u' -> up;
            case 'd' -> down;
            default -> null;
        };
    }

    public boolean isValidDirection(char Direction) {

        if(Direction == 'n') {
            if (north != null) {
                return true;
            }
        }

        if(Direction == 's') {
            if (south != null) {
                return true;
            }
        }

        if(Direction == 'e') {
            if (east != null) {
                return true;
            }
        }

        if(Direction == 'w') {
            if (west != null) {
                return true;
            }
        }

        return false;
    }
    
    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setDown(Room down) {
        this.down = down;
    }
}
