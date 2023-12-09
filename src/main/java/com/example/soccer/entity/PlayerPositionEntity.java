package com.example.soccer.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "player_positions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayerPositionEntity {
    @EmbeddedId
    private PlayerPositionPK id;

    public PlayerPositionEntity(PlayerPositionPK id) {
        this.id = id;
    }
    public String getPositionName() {
        return id.position.getName();
    }

    @Embeddable
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    static public class PlayerPositionPK implements Serializable {
        @JoinColumn(name = "player_id")
        @ManyToOne(fetch = FetchType.LAZY)
        private PlayerEntity player;
        @JoinColumn(name = "position_name")
        @ManyToOne(fetch = FetchType.LAZY)
        private PositionEntity position;

        public PlayerPositionPK(PlayerEntity playerEntity, PositionEntity positionEntity) {
            this.player = playerEntity;
            this.position = positionEntity;
        }
    }
}
