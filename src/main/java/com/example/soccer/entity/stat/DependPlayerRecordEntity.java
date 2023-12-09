package com.example.soccer.entity.stat;

import com.example.soccer.entity.PlayerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "player_depend_records")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DependPlayerRecordEntity extends PlayerRecordEntity {
    private Integer tackles;
    private Integer tackleWins;
    private Integer tacklesInDeffensiveThird;
    private Integer tacklesInMiddleThird;
    private Integer tacklesInAttackingThird;
    private Integer challengedDribbles;
    private Integer losts;
    private Integer blocks;
    private Integer shotBlocks;
    private Integer passBlocks;
    private Integer interceptions;
    private Integer clearances;

    public DependPlayerRecordEntity(PlayerEntity playerEntity, Double _90s, Integer ranks,
                                    Integer tackles, Integer tackleWins, Integer tacklesInDeffensiveThird,
                                    Integer tacklesInMiddleThird, Integer tacklesInAttackingThird,
                                    Integer challengedDribbles, Integer losts, Integer blocks,
                                    Integer shotBlocks, Integer passBlocks, Integer interceptions,
                                    Integer clearances) {
        super(playerEntity, _90s, ranks);
        this.tackles = tackles;
        this.tackleWins = tackleWins;
        this.tacklesInDeffensiveThird = tacklesInDeffensiveThird;
        this.tacklesInMiddleThird = tacklesInMiddleThird;
        this.tacklesInAttackingThird = tacklesInAttackingThird;
        this.challengedDribbles = challengedDribbles;
        this.losts = losts;
        this.blocks = blocks;
        this.shotBlocks = shotBlocks;
        this.passBlocks = passBlocks;
        this.interceptions = interceptions;
        this.clearances = clearances;
    }
}
