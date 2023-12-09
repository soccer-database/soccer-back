package com.example.soccer.domain.squad;

import com.example.soccer.entity.SquadEntity;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class SquadReader {

    private final SquadReadRepository repository;

    public SquadEntity getSquadBy(Long playerId) {
        return repository.findByPlayerId(playerId);
    }

    public SquadEntity getSquadBy(String name) {
        return repository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Map<String, SquadEntity> getMap() {
        return repository.findAll().stream()
            .collect(Collectors.toMap(SquadEntity::getName, e -> e));
    }
}
