package com.example.soccer.entity;

import com.example.soccer.entity.PlayerPositionEntity.PlayerPositionPK;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "players")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayerEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @JoinColumn(name = "nation_name")
    @ManyToOne
    private NationEntity nation;
    private Integer backNumber;
    @JoinColumn(name = "squad_name")
    @ManyToOne
    private SquadEntity squad;
    private Integer birthYear;

    @OneToMany(mappedBy = "id.player", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PlayerPositionEntity> positions = new LinkedHashSet<>();
    @OneToMany(mappedBy = "player", cascade = CascadeType.PERSIST)
    private List<PlayerRecordEntity> records = new LinkedList<>();
    private String profileUrl;
    public PlayerEntity(String name, NationEntity nationEntity, SquadEntity squad, Integer birthYear,
                        Set<PositionEntity> positionEntities, List<PlayerRecordEntity> records, String profileUrl, Integer backNumber) {
        this.name = name;
        this.nation = nationEntity;
        this.squad = squad;
        this.birthYear = birthYear;
        this.positions = positionEntities.stream().map(positionEntity -> {
            PlayerPositionPK playerPositionPK = new PlayerPositionPK(this, positionEntity);
            return new PlayerPositionEntity(playerPositionPK);
        }).collect(Collectors.toSet());
        this.records = records;
        this.records.forEach(playerRecord -> playerRecord.assignPlayer(this));
        this.profileUrl = profileUrl;
        this.backNumber = backNumber;
    }

    public void changeInformation(Integer backNumber, String profileUrl) {
        this.backNumber = backNumber;
        this.profileUrl = profileUrl;
    }
}
