package com.silver.dragons.services;

import com.silver.dragons.dal.MessageResultRepository;
import com.silver.dragons.entities.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageResultRepository messageResultRepository;

    @Autowired
    public MessageService(MessageResultRepository messageResultRepository) {
        this.messageResultRepository = messageResultRepository;
    }

    public List<MessageResult> findMessagesByGameId(String gameId)
    {
        return this.messageResultRepository.findMessagesByGameId(gameId);
    }

    public void addMessageResults(List<MessageResult> messageResults)
    {
        this.messageResultRepository.saveAll(messageResults);
    }

    public List<MessageResult> getMessages(String gameId) {
        return this.messageResultRepository.findMessagesByGameId(gameId);
    }
}
