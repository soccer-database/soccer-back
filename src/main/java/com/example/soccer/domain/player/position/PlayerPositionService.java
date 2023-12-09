package com.example.soccer.domain.player.position;

import com.example.soccer.entity.PlayerPositionEntity;
import com.example.soccer.entity.PlayerPositionEntity.PlayerPositionPK;
import com.example.soccer.entity.PositionEntity;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerPositionService {

    private final PlayerPositionRepository playerPositionRepository;

    public Map<Long, Set<PlayerPositionEntity>> getPositionBy(List<Long> playerIds) {
        Set<PlayerPositionEntity> positions = playerPositionRepository.findById_Player_IdIn(
            playerIds);
        if (positions == null) {
            return Map.of();
        }
        return positions.stream().collect(Collectors.groupingBy(
            playerPositionEntity -> playerPositionEntity.getId().getPlayer().getId(),
            Collectors.toSet()));
    }

    public Set<PositionEntity> getPositionBy(Long playerId) {
        return playerPositionRepository.findById_Player_id(playerId).stream()
            .map(PlayerPositionEntity::getId).map(PlayerPositionPK::getPosition)
            .collect(Collectors.toSet());
    }
}
