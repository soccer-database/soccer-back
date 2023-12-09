package com.example.soccer.entity.stat;

import com.example.soccer.entity.PlayerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Table(name = "player_records")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class PlayerRecordEntity {
    @Id
    @GeneratedValue
    private Long id;
    @JoinColumn(name = "player_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PlayerEntity player;

    private Double s90;
    private Integer ranks;

    public PlayerRecordEntity(PlayerEntity playerEntity, Double s90, Integer ranks) {
        this.player = playerEntity;
        this.s90 = s90;
        this.ranks = ranks;
    }
    public void assignPlayer(PlayerEntity playerEntity) {
        this.player = playerEntity;
    }
}
