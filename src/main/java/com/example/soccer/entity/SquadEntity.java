package com.example.soccer.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "squads")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SquadEntity {
    @Id
    private String name;
    private String manager;
    private LocalDate founded;
    private String owner;
    private String color;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "stadium_name")
    private StadiumEntity stadium;

    public SquadEntity(String name, String manager, LocalDate founded, String owner, String color,
                       StadiumEntity stadium) {
        this.name = name;
        this.manager = manager;
        this.founded = founded;
        this.owner = owner;
        this.color = color;
        this.stadium = stadium;
    }

    public void patch(SquadEntity entity) {
        manager = entity.getManager();
        founded = entity.getFounded();
        owner = entity.getOwner();
        color = entity.getColor();
        stadium = entity.getStadium();
    }
}
