package com.example.soccer.domain.nation;

import com.example.soccer.entity.NationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class NationWriter {
    private final NationWriteRepository repository;

    @Transactional
    public void save(NationEntity entity) {
        repository.save(entity);
    }
}
