package com.example.soccer.domain.nation;

import com.example.soccer.entity.NationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface NationWriteRepository extends JpaRepository<NationEntity, String> {

}
