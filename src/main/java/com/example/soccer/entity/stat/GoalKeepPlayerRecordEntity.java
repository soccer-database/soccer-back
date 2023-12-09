package com.example.soccer.entity.stat;

import com.example.soccer.entity.PlayerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "player_goal_keep_records")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoalKeepPlayerRecordEntity extends PlayerRecordEntity {
    private Integer goalsAgainst;
    private Integer shootsOnTargetAgainst;
    private Integer saves;
    private Integer wins;
    private Integer draws;
    private Integer loses;
    private Integer cleanSheets;
    private Integer penaltyKickAttempted;
    private Integer penaltyKickAgainsts;
    private Integer penaltyKickSaves;
    private Integer penaltyKickMisses;

    public GoalKeepPlayerRecordEntity(PlayerEntity playerEntity, Double _90s, Integer ranks,
                                      Integer goalsAgainst, Integer shootsOnTargetAgainst, Integer saves,
                                      Integer wins, Integer draws, Integer loses, Integer cleanSheets,
                                      Integer penaltyKickAttempted, Integer penaltyKickAgainsts,
                                      Integer penaltyKickSaves, Integer penaltyKickMisses) {
        super(playerEntity, _90s, ranks);
        this.goalsAgainst = goalsAgainst;
        this.shootsOnTargetAgainst = shootsOnTargetAgainst;
        this.saves = saves;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.cleanSheets = cleanSheets;
        this.penaltyKickAttempted = penaltyKickAttempted;
        this.penaltyKickAgainsts = penaltyKickAgainsts;
        this.penaltyKickSaves = penaltyKickSaves;
        this.penaltyKickMisses = penaltyKickMisses;
    }
}
