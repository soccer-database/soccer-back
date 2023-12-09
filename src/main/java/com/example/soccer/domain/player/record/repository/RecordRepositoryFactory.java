package com.example.soccer.domain.player.record.repository;

import com.example.soccer.domain.classes.PlayerRecordType;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecordRepositoryFactory {
    private final DependRecordReadRepository dependRecordRepository;
    private final PassRecordReadRepository passRecordRepository;
    private final GoalKeepRecordReadRepository goalKeepRecordRepository;
    private final ShootRecordReadRepository shootRecordRepository;
    private final StandardRecordReadRepository standardRecordRepository;

    public PlayerRecordReadRepository<? extends PlayerRecordEntity> getRepository(PlayerRecordType type) {
        switch (type) {
            case GK -> {
                return goalKeepRecordRepository;
            }
            case pass ->
            {
                return passRecordRepository;
            }
            case shoot ->
            {
                return shootRecordRepository;
            }
            case standard ->
            {
                return standardRecordRepository;
            }
            case depend -> {
                return dependRecordRepository;
            }
        }
        throw new RuntimeException("해당되는 타입에 매칭되는 레포지터리가 없습니다.");
    }
}
