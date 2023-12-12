package com.example.soccer.domain.squad;

import com.example.soccer.entity.SquadMatchRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRecordWriteRepository extends JpaRepository<SquadMatchRecordEntity, Long> {

}
