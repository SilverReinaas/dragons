package com.silver.dragons.dal;

import com.silver.dragons.entities.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameResult, String> {

}
