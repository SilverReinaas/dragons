package com.silver.dragons.logic;

import com.silver.dragons.dragonapi.*;
import com.silver.dragons.entities.GameResult;
import com.silver.dragons.entities.MessageResult;
import com.silver.dragons.services.DragonApiService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Gameplay {

    private final DragonApiService dragonApiService;

    //Local variables to track the game process
    private String gameId;
    private int lives;
    private int score;
    private int turns;
    private int gold;
    private int level;

    private List<MessageResult> messageResults;

    public Gameplay() {
        //Layer to communicate with game api
        dragonApiService = new DragonApiService();
    }

    public String getGameId() {
        return gameId;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public int getTurns() {
        return turns;
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }

    public List<MessageResult> getMessageResults() {
        return messageResults;
    }

    public void setMessageResults(List<MessageResult> messageResults) {
        this.messageResults = messageResults;
    }

    public GameResult getGameResult() {
        GameResult gameResult = new GameResult(
                this.getGameId(),
                this.getScore(),
                this.getTurns(),
                LocalDateTime.now());

        return gameResult;
    }

    public void play() {

        //Start the game
        GameResponse gameResponse = dragonApiService.getNewGame();

        //Init local variables to keep track of the game process
        gameId = gameResponse.getGameId();
        lives = gameResponse.getLives();
        score = gameResponse.getScore();
        turns = gameResponse.getTurn();
        level = gameResponse.getLevel();
        gold = gameResponse.getGold();
        messageResults = new ArrayList<>();

        //Get shop items
        var shopResponseList = dragonApiService.getShopItems(this.getGameId());

        //Get messages for the game
        List<MessageResponse> messageResponses = dragonApiService.getMessages(this.getGameId());

        //Iterate the game messages till empty or dead
        //...it seems that it never gets empty
        while (!messageResponses.isEmpty() && lives > 0) {
            //Get the first message
            MessageResponse messageResponse = messageResponses.get(0);

            //Save message info to gameplay
            var messageResult = new MessageResult(
                    messageResponse.getAdId(),
                    messageResponse.getMessage(),
                    messageResponse.getReward(),
                    messageResponse.getProbability()
            );

            //Try to solve the message
            SolveMessageResponse solveMessageResponse = dragonApiService.solveMessage(this.getGameId(), messageResponse.getAdId());
            lives = solveMessageResponse.getLives();
            score = solveMessageResponse.getScore();
            turns = solveMessageResponse.getTurn();
            gold = solveMessageResponse.getGold();

            messageResult.setSuccess(solveMessageResponse.getSuccess());
            messageResults.add(messageResult);

            if (lives > 0) {
                //Try to buy healing pot
                tryToPurchase("hpot", shopResponseList);

                //Refresh message list
                messageResponses = dragonApiService.getMessages(this.getGameId());
            }
        }
    }

    private Boolean tryToPurchase(String itemId, List<ShopResponse> shopResponseList)
    {
        ShopResponse item = shopResponseList.stream().filter(x -> x.getId().equals(itemId)).findFirst().orElse(null);
        if(item != null)
        {
            if(gold > item.getCost())
            {
                PurchaseResponse purchaseResponse = dragonApiService.purchase(this.getGameId(), itemId);
                return purchaseResponse.getShoppingSuccess();
            }
        }
        return false;
    }

}
