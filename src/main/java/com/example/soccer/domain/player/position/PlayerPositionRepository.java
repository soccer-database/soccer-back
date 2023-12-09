package com.example.soccer.domain.player.position;

import com.example.soccer.entity.PlayerPositionEntity;
import com.example.soccer.entity.PlayerPositionEntity.PlayerPositionPK;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerPositionRepository extends JpaRepository<PlayerPositionEntity, PlayerPositionPK> {
    @EntityGraph(attributePaths = "id.position")
    Set<PlayerPositionEntity> findById_Player_IdIn(Collection<Long> ids);
    @EntityGraph(attributePaths = "id.position")
    Set<PlayerPositionEntity> findById_Player_id(Long playerId);
}