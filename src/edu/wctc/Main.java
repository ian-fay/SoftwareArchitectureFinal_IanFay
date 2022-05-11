package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Maze maze = Maze.buildMaze();
        ConsoleOutput consoleOutput = new ConsoleOutput();


        consoleOutput.printText("You have successfully entered into the destroyed scout ship the 'U.S.S Gutpunch'. \n Your mission is to find the crew, retrieve the Blackbox, and get out. ");
        consoleOutput.printText(" \n Controls: \n Movement: 'n' [North], 's' [South], 'e' [East], 'w' [West], 'u' [Up], and 'd' [Down]. \n Interaction: 'i' [Interact] \n" +
                " 'l' (lower case L) [Loot] " +
                " 'x' [Leave Maze] (Can Only be Done in Certain Rooms)" +
                "'v' [Inventory]");
        consoleOutput.printText(maze.getCurrentRoomDescription());
        consoleOutput.printText(maze.getCurrentRoomExits());

        while(!maze.isFinished) {

            Scanner userInput = new Scanner(System.in);
            char input = userInput.nextLine().toLowerCase().charAt(0);

            switch (input) {
                case 'n':
                case 'd':
                case 'u':
                case 'w':
                case 'e':
                case 's':
                    if (maze.Move(input)) {
                        consoleOutput.printText(maze.getCurrentRoomExits());
                        consoleOutput.printText(maze.getCurrentRoomDescription());//print out Maze.GetCurrentRoomDescription and Maze.GetCurrentRoomExits
                    }
                    break;
                case 'i':
                    consoleOutput.printText(maze.interactWithCurrentRoom());
                    break;
                case 'l':
                    consoleOutput.printText(maze.lootCurrentRoom());
                    break;
                case 'x':
                    consoleOutput.printText(maze.exitCurrentRoom());
                    break;
                case 'v':
                    consoleOutput.printList(Player.getInventory());
                    break;
                default:
                    consoleOutput.printText("That is not a valid command.");
            }
        }

        if (maze.isFinished) {
            consoleOutput.printText("Score:" + Player.getScore());
        }

    }
}
