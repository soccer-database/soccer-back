package com.example.soccer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nations")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NationEntity {
    @Id
    private String name;

    public NationEntity(String name) {
        this.name = name;
    }
}
