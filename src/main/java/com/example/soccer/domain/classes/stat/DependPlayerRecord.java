package com.example.soccer.domain.classes.stat;


import com.example.soccer.entity.PlayerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class DependPlayerRecord extends PlayerRecord {
    private final Integer tackles;
    private final Integer tackleWins;
    private final Integer tacklesInDeffensiveThird;
    private final Integer tacklesInMiddleThird;
    private final Integer tacklesInAttackingThird;
    private final Integer challengedDribbles;
    private final Integer losts;
    private final Integer blocks;
    private final Integer shotBlocks;
    private final Integer passBlocks;
    private final Integer interceptions;
    private final Integer clearances;

    public DependPlayerRecord(Long id, Double s90, Integer ranks, Integer tackles,
                              Integer tackleWins,
                              Integer tacklesInDeffensiveThird, Integer tacklesInMiddleThird,
                              Integer tacklesInAttackingThird, Integer challengedDribbles,
                              Integer losts, Integer blocks, Integer shotBlocks, Integer passBlocks,
                              Integer interceptions, Integer clearances) {
        super(id, s90, ranks);
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
