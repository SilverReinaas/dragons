package com.silver.dragons.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class GameResult {
    @Id
    private String gameId;
    private Integer score;
    private Integer turns;
    private LocalDateTime dateTime;

    public GameResult() {
    }

    public GameResult(String gameId, Integer score, Integer turns, LocalDateTime dateTime) {
        this.gameId = gameId;
        this.score = score;
        this.turns = turns;
        this.dateTime = dateTime;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTurns() {
        return turns;
    }

    public void setTurns(Integer turns) {
        this.turns = turns;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
