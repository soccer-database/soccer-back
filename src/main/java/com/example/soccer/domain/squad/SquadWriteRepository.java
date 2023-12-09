package com.example.soccer.domain.squad;

import com.example.soccer.entity.SquadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface SquadWriteRepository extends JpaRepository<SquadEntity, String> {

}
