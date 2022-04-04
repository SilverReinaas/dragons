package com.silver.dragons.dragonapi;

public class PurchaseResponse {
    private Boolean shoppingSuccess;
    private int gold;
    private int lives;
    private int level;
    private int turn;

    public int getGold() {
        return gold;
    }

    public int getLives() {
        return lives;
    }

    public int getLevel() {
        return level;
    }

    public int getTurn() {
        return turn;
    }

    public Boolean getShoppingSuccess() {
        return shoppingSuccess;
    }
}
