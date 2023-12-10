package com.example.soccer.domain.player;

import com.example.soccer.CsvParser;
import com.example.soccer.domain.classes.Player;
import com.example.soccer.domain.classes.PlayerDetail;
import com.example.soccer.domain.classes.PlayerRecordType;
import com.example.soccer.domain.classes.SquadName;
import com.example.soccer.domain.classes.stat.PlayerRecord;
import com.example.soccer.domain.player.model.PlayerDto.PostBulk;
import com.example.soccer.domain.player.record.PlayerRecordService;
import com.example.soccer.entity.NationEntity;
import com.example.soccer.entity.PlayerEntity;
import com.example.soccer.entity.PositionEntity;
import com.example.soccer.entity.SquadEntity;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import com.example.soccer.entity.stat.StandardPlayerRecordEntity;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("players")
@RequiredArgsConstructor
class PlayerController {

    private final CsvParser csvParser;
    private final PlayerService playerService;
    private final PlayerRecordService recordService;

    @GetMapping
    @Operation(summary = "팀 이름에 따른 선수목록 조회")
    public List<Player> getPlayers(@NotNull SquadName squadName) {
        return playerService.getPlayersBy(squadName.name);
    }

    @GetMapping("{id}")
    @Operation(summary = "선수 상세정보 조회 (기록 제외)")
    public PlayerDetail getPlayerDetail(@PathVariable Long id) {
        return playerService.getPlayerDetailBy(id);
    }

    @PatchMapping("bulk")
    public void updatePlayers(@RequestBody PostBulk dto) {
        dto.players().forEach(playerInformation -> {
            playerService.changeInformation(dto.squadName(), playerInformation.Name(),
                playerInformation.img(), playerInformation.SquadNumber());
        });
    }

    @GetMapping("{id}/records")
    @Operation(summary = "선수 depend, GK, shoot, pass, standard 기록 조회")
    public PlayerRecord getRecordByType(PlayerRecordType type, @PathVariable Long id) {
        return recordService.getPlayerRecordBy(id, type);
    }
}
