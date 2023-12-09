package com.example.soccer.domain.player.record;

import com.example.soccer.domain.classes.PlayerRecordType;
import com.example.soccer.domain.classes.stat.DependPlayerRecord;
import com.example.soccer.domain.classes.stat.GoalKeepPlayerRecord;
import com.example.soccer.domain.classes.stat.PassPlayerRecord;
import com.example.soccer.domain.classes.stat.PlayerRecord;
import com.example.soccer.domain.classes.stat.ShootPlayerRecord;
import com.example.soccer.domain.classes.stat.StandardPlayerRecord;
import com.example.soccer.entity.stat.DependPlayerRecordEntity;
import com.example.soccer.entity.stat.GoalKeepPlayerRecordEntity;
import com.example.soccer.entity.stat.PassPlayerRecordEntity;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import com.example.soccer.entity.stat.ShootPlayerRecordEntity;
import com.example.soccer.entity.stat.StandardPlayerRecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerRecordMapper {
    PlayerRecordMapper INSTANCE = Mappers.getMapper(PlayerRecordMapper.class);
    default PlayerRecord toPlayerRecord(PlayerRecordEntity entity) {
        if (entity instanceof ShootPlayerRecordEntity shootPlayerRecord) {
            return toDomain(shootPlayerRecord);
        }
        if (entity instanceof GoalKeepPlayerRecordEntity goalKeepPlayerRecord) {
            return toDomain(goalKeepPlayerRecord);
        }
        if (entity instanceof StandardPlayerRecordEntity standardPlayerRecord) {
            return toDomain(standardPlayerRecord);
        }
        if (entity instanceof PassPlayerRecordEntity passPlayerRecord) {
            return toDomain(passPlayerRecord);
        }
        if (entity instanceof DependPlayerRecordEntity dependPlayerRecord) {
            return toDomain(dependPlayerRecord);
        }
        return null;
    };
    @Mapping(target = "id", source = "id")
    StandardPlayerRecord toDomain(StandardPlayerRecordEntity entity);
    GoalKeepPlayerRecord toDomain(GoalKeepPlayerRecordEntity entity);
    ShootPlayerRecord toDomain(ShootPlayerRecordEntity entity);
    PassPlayerRecord toDomain(PassPlayerRecordEntity entity);
    DependPlayerRecord toDomain(DependPlayerRecordEntity entity);
}
