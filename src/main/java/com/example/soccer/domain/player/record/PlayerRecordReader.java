package com.example.soccer.domain.player.record;

import com.example.soccer.domain.classes.PlayerRecordType;
import com.example.soccer.domain.player.record.repository.RecordRepositoryFactory;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerRecordReader {

    private final RecordRepositoryFactory repositoryFactory;

    public PlayerRecordEntity readBy(Long playerId, PlayerRecordType type) {
        return repositoryFactory.getRepository(type).findByPlayer_Id(playerId)
            .orElseThrow(() -> new RuntimeException("해당 선수에게 해당 타입의 기록 정보가 없습니다."));
    }
}
