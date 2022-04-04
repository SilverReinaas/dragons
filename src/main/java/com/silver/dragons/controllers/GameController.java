package com.silver.dragons.controllers;

import com.silver.dragons.entities.GameResult;
import com.silver.dragons.entities.MessageResult;
import com.silver.dragons.logic.Gameplay;
import com.silver.dragons.services.GameService;
import com.silver.dragons.services.MessageService;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/game")
public class GameController {

    private final GameService gameService;
    private final MessageService messageService;

    @Autowired
    public GameController(GameService gameService, MessageService messageService) {
        this.gameService = gameService;
        this.messageService = messageService;
    }

    @GetMapping
    @RequestMapping("/all")
    public List<GameResult> getGames() {
        var res = gameService.getGames();
        Collections.reverse(res);
        return res;
    }

    @PostMapping
    public void addGame(@RequestBody GameResult game) {
        gameService.addGame(game);
    }

    @DeleteMapping(path = "{gameId}")
    public void deleteGame(@PathVariable("gameId") String id) {
        gameService.deleteGame(id);
    }

    @GetMapping(path = "/messages/{gameId}")
    public List<MessageResult> getMessages(@PathVariable("gameId") String gameId) {
        var res = messageService.getMessages(gameId);
        return res;
    }

    @PostMapping(path = "/messages/{gameId}")
    public void addMessages(@RequestBody List<MessageResult> messageResults, @PathVariable("gameId") String gameId)
    {
        var gameResult = gameService.getGameById(gameId);
        if(gameResult.isPresent())
        {
            messageResults.forEach(m -> m.setGameResult(gameResult.get()));
            messageService.addMessageResults(messageResults);
        }
        else
        {
            throw new InvalidRequestStateException("Game not found");
        }
    }

    @GetMapping
    @RequestMapping("/play")
    public Gameplay playNewGame() {
        Gameplay gameplay = new Gameplay();
        gameplay.play();
        return gameplay;
    }
}
