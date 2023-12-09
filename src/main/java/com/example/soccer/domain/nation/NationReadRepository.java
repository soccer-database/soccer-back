package com.example.soccer.domain.nation;

import com.example.soccer.entity.NationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationReadRepository extends JpaRepository<NationEntity, String> {
    NationEntity findByName(String name);
}
