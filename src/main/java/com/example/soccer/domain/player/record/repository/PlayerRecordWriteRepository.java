package com.example.soccer.domain.player.record.repository;

import com.example.soccer.entity.stat.PlayerRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRecordWriteRepository extends JpaRepository<PlayerRecordEntity, Long> {

}
