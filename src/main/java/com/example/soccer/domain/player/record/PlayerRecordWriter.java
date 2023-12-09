package com.example.soccer.domain.player.record;

import com.example.soccer.domain.player.record.repository.PlayerRecordWriteRepository;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PlayerRecordWriter {
    private final PlayerRecordWriteRepository repository;

    @Transactional
    public void save(PlayerRecordEntity entity) {
        repository.save(entity);
    }
}
