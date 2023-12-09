package com.example.soccer.domain.classes.stat;

import com.example.soccer.entity.PlayerEntity;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class GoalKeepPlayerRecord extends PlayerRecord {
    private final Integer goalsAgainst;
    private final Integer shootsOnTargetAgainst;
    private final Integer saves;
    private final Integer wins;
    private final Integer draws;
    private final Integer loses;
    private final Integer cleanSheets;
    private final Integer penaltyKickAttempted;
    private final Integer penaltyKickAgainsts;
    private final Integer penaltyKickSaves;
    private final Integer penaltyKickMisses;

    public GoalKeepPlayerRecord(Long id, Double s90, Integer ranks, Integer goalsAgainst,
                                Integer shootsOnTargetAgainst, Integer saves, Integer wins,
                                Integer draws, Integer loses, Integer cleanSheets,
                                Integer penaltyKickAttempted, Integer penaltyKickAgainsts,
                                Integer penaltyKickSaves, Integer penaltyKickMisses) {
        super(id, s90, ranks);
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
