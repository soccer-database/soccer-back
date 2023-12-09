package com.example.soccer.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NationRepository extends JpaRepository<NationEntity, String> {

    NationEntity findByName(String name);

}