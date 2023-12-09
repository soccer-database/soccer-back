package com.example.soccer.domain.player.position;

import com.example.soccer.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionEntity, String> {
    PositionEntity findByName(String name);
}