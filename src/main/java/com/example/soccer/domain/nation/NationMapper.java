package com.example.soccer.domain.nation;

import com.example.soccer.entity.NationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface NationMapper {
    NationMapper INSTANCE = Mappers.getMapper(NationMapper.class);
    NationEntity toEntity(String name);
}
