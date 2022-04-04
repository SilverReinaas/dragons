package com.silver.dragons.dragonapi;

public class SolveMessageResponse {
    private Boolean success;
    private Integer lives;
    private Integer gold;
    private Integer score;
    private Integer highScore;
    private Integer turn;
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public Integer getLives() {
        return lives;
    }

    public Integer getGold() {
        return gold;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public Integer getTurn() {
        return turn;
    }

    public String getMessage() {
        return message;
    }
}
