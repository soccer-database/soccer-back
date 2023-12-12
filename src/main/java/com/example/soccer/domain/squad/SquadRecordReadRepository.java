package com.example.soccer.domain.squad;

import com.example.soccer.entity.SquadMatchRecordEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRecordReadRepository extends JpaRepository<SquadMatchRecordEntity, Long> {

    List<SquadMatchRecordEntity> findByHomeSquad_NameOrAwaySquad_NameOrderByWeek(
        String homeSquad_name, String awaySquad_name);
}
