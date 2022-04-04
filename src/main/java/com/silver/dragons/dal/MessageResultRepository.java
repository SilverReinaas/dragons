package com.silver.dragons.dal;

import com.silver.dragons.entities.MessageResult;
import org.aspectj.bridge.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageResultRepository extends JpaRepository<MessageResult, String> {

    @Query("SELECT m FROM MessageResult m WHERE m.gameResult.gameId =  ?1")
    List<MessageResult> findMessagesByGameId(String gameId);
}
