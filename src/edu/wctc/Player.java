package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int score;
    private static List<String> inventory;

    public Player() {
        score = 0;
        inventory = new ArrayList<>();
    }

    public void addToInventory(String item) {
        inventory.add(item);

    }

    public void addToScore(int scoreAddition) {
        score += scoreAddition;
    }

    public static int getScore() {
        return score;
    }

    public static List<String> getInventory() {
        return inventory;
    }
}
