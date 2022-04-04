package com.silver.dragons.dragonapi;

public class MessageResponse {
    private String adId;
    private String message;
    private String reward;
    private Integer expiresIn;
    private String probability;

    public String getAdId() {
        return adId;
    }

    public String getMessage() {
        return message;
    }

    public String getReward() {
        return reward;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public String getProbability() {
        return probability;
    }
}
