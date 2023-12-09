package com.example.soccer.domain.nation;

import com.example.soccer.entity.NationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NationService {
    private final NationWriter writer;
    private final NationMapper mapper = NationMapper.INSTANCE;
    private final NationReader reader;

    @Transactional
    public void insertByName(String name) {
        writer.save(mapper.toEntity(name));
    }

    public NationEntity readBy(String name) {
        return reader.findBy(name);
    }
}
