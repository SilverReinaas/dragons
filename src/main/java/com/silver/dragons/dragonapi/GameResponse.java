package com.silver.dragons.dragonapi;

public class GameResponse {
    private String gameId;
    private Integer score;
    private Integer gold;
    private Integer level;
    private Integer turn;
    private Integer lives;
    private Integer highScore;

    public String getGameId() {
        return gameId;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getGold() {
        return gold;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getTurn() {
        return turn;
    }

    public Integer getLives() {
        return lives;
    }

    public Integer getHighScore() {
        return highScore;
    }
}
