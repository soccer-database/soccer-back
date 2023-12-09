package com.example.soccer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "stadiums")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StadiumEntity {
    @Id
    private String name;
    private Double latitude;
    private Double longitude;
    private Integer capacity;

    public StadiumEntity(String name, Double latitude, Double longitude, Integer capacity) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.capacity = capacity;
    }
}
