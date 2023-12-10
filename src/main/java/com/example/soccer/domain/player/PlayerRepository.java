package com.example.soccer.domain.player;

import com.example.soccer.entity.PlayerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

    List<PlayerEntity> findBySquad_NameOrderByBackNumber(String squad_name);

    PlayerEntity findBySquad_NameAndName(String squad_name, String name);
}