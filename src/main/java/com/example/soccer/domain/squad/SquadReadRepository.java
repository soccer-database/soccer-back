package com.example.soccer.domain.squad;

import com.example.soccer.entity.SquadEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface SquadReadRepository extends JpaRepository<SquadEntity, String> {

    @EntityGraph(attributePaths = {"stadium"})
    SquadEntity findByName(String name);
    @Query("select sq from PlayerEntity p join SquadEntity sq on p.squad = sq where p.id=:playerId")
    SquadEntity findByPlayerId(Long playerId);
}