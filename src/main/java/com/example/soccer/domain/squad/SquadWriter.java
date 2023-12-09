package com.example.soccer.domain.squad;

import com.example.soccer.entity.SquadEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class SquadWriter {
    private SquadWriteRepository repository;

    @Transactional
    public void save(SquadEntity entity) {
        repository.save(entity);
    }
}
