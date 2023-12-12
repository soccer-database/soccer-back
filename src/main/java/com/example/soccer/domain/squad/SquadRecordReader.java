package com.example.soccer.domain.squad;

import com.example.soccer.entity.SquadMatchRecordEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SquadRecordReader {

    private final SquadRecordReadRepository repository;

    @Transactional(readOnly = true)
    public List<SquadMatchRecordEntity> findByTeam(String squadName) {
        return repository.findByHomeSquad_NameOrAwaySquad_NameOrderByWeek(squadName,
            squadName);
    }
}
