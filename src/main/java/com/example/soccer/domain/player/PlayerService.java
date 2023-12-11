package com.example.soccer.domain.player;

import com.example.soccer.domain.classes.Player;
import com.example.soccer.domain.classes.PlayerDetail;
import com.example.soccer.domain.classes.SquadSummary;
import com.example.soccer.domain.player.position.PlayerPositionService;
import com.example.soccer.domain.squad.SquadService;
import com.example.soccer.entity.PlayerEntity;
import com.example.soccer.entity.PlayerPositionEntity;
import com.example.soccer.entity.PositionEntity;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerPositionService playerPositionService;
    private final SquadService squadService;

    public List<Player> getPlayersBy(String squad) {
        List<PlayerEntity> players = playerRepository.findBySquad_NameAndBackNumberIsNotNullOrderByBackNumber(
            squad);
        Map<Long, Set<PlayerPositionEntity>> positionMap = playerPositionService.getPositionBy(
            players.stream().map(PlayerEntity::getId).toList());
        return players.stream().map(
                playerEntity -> new Player(playerEntity.getId(), playerEntity.getProfileUrl(),
                    playerEntity.getName(), playerEntity.getBackNumber(),
                    positionMap.get(playerEntity.getId()).stream()
                        .map(PlayerPositionEntity::getPositionName).collect(Collectors.toSet())))
            .toList();
    }

    public PlayerDetail getPlayerDetailBy(Long playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
            .orElseThrow(() -> new RuntimeException("해당되는 선수가 없습니다."));
        Set<PositionEntity> positions = playerPositionService.getPositionBy(player.getId());
        SquadSummary squad = squadService.getSquadSummaryBy(player.getId());
        return new PlayerDetail(player.getId(), player.getProfileUrl(), player.getName(),
            player.getBackNumber(),
            positions.stream().map(PositionEntity::getName).collect(Collectors.toSet()),
            player.getNation().getName(), player.getBirthYear(), squad);
    }
    public PlayerEntity readBy(String squadName, String playerName) {
        return playerRepository.findBySquad_NameAndName(squadName, playerName);
    }

    @Transactional
    public void changeInformation(String squadName, String name, String profileUrl,
                                  Integer backNumber) {
        PlayerEntity player = playerRepository.findBySquad_NameAndName(squadName, name);
        if (player != null) {
            player.changeInformation(backNumber, profileUrl);
        }
    }
}
