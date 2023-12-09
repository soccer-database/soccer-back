package com.example.soccer.domain.nation;

import com.example.soccer.entity.NationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NationReader {
    private final NationReadRepository repository;
    @Transactional(readOnly = true)
    public NationEntity findBy(String name) {
        return repository.findByName(name);
    }
}
