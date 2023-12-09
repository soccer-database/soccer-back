package com.example.soccer.domain.squad;

import com.example.soccer.domain.classes.SquadSummary;
import com.example.soccer.domain.classes.SquadDetail;
import com.example.soccer.domain.classes.Stadium;
import com.example.soccer.domain.squad.model.SquadDto.PatchSquad;
import com.example.soccer.entity.SquadEntity;
import com.example.soccer.entity.StadiumEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
interface SquadMapper {
    SquadMapper INSTANCE = Mappers.getMapper(SquadMapper.class);
    SquadSummary toDomain(SquadEntity entity);
    @Mapping(target = "name", source = "name")
    SquadDetail toDetailDomain(SquadEntity entity);
    SquadEntity toEntity(PatchSquad dto);
    SquadEntity toEntity(String name);
    StadiumEntity toEntity(Stadium dto);
}
