package com.silver.dragons.services;

import java.util.Arrays;
import java.util.List;

import com.silver.dragons.dragonapi.*;

import org.springframework.web.client.RestTemplate;

public class DragonApiService {

    public DragonApiService() {
    }

    public GameResponse getNewGame()
    {
        GameResponse gameResponse = restPost(
                "https://dragonsofmugloar.com/api/v2/game/start",
                null,
                GameResponse.class
        );
        return gameResponse;
    }

    public List<MessageResponse> getMessages(String gameId){
        //api returns array
        MessageResponse[] messageResponses = restGet(
                String.format("https://dragonsofmugloar.com/api/v2/%1s/messages", gameId),
                MessageResponse[].class
        );
        return Arrays.asList(messageResponses);
    }

    public SolveMessageResponse solveMessage(String gameId, String adId) {
        SolveMessageResponse solveMessageResponse = restPost(
                String.format("https://dragonsofmugloar.com/api/v2/%1s/solve/%2s", gameId, adId),
                null,
                SolveMessageResponse.class
        );
        return  solveMessageResponse;
    }

    public List<ShopResponse> getShopItems(String gameId)
    {
        ShopResponse[] shopResponses = restGet(
                String.format("https://dragonsofmugloar.com/api/v2/%1s/shop", gameId),
                ShopResponse[].class
        );
        return Arrays.asList(shopResponses);
    }

    public PurchaseResponse purchase(String gameId, String itemId)
    {
        PurchaseResponse purchaseResponse = restPost(
                String.format("https://dragonsofmugloar.com/api/v2/%1s/shop/buy/%2s", gameId, itemId),
                null,
                PurchaseResponse.class
        );
        return purchaseResponse;
    }

    public <T> T restPost(String url, Object request, Class<T> responseType)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, request, responseType);
    }

    public <T> T restGet(String url, Class<T> responseType)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, responseType);
    }


}
