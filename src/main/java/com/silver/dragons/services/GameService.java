package com.silver.dragons.services;

import com.silver.dragons.dal.GameRepository;
import com.silver.dragons.entities.GameResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameResult> getGames(){
        return gameRepository.findAll();
    }

    public void addGame(GameResult game){
        Optional<GameResult> dbGame = gameRepository.findById(game.getGameId());
        if(dbGame.isPresent()){
            throw new IllegalStateException("game id already exists");
        }
        gameRepository.save(game);
    }

    public Optional<GameResult> getGameById(String id)
    {
        return gameRepository.findById(id);
    }

    public void deleteGame(String id) {
        gameRepository.deleteById(id);
    }

}
