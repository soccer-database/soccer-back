package com.example.soccer.domain.player.record.repository;

import com.example.soccer.entity.stat.PlayerRecordEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRecordReadRepository<T extends PlayerRecordEntity> extends JpaRepository<T, Long> {
    Optional<T> findByPlayer_Id(Long playerId);

}
