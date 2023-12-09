package com.example.soccer.domain.classes.stat;

import com.example.soccer.entity.PlayerEntity;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ShootPlayerRecord extends PlayerRecord {
    private final Integer goalCount;
    private final Integer totalShot;
    private final Integer onTargetShot;
    private final Double distance;
    private final Integer freekick;
    private final Integer countOfPenaltyKickMade;
    private final Integer countOfPenaltyKickAttempted;

    public ShootPlayerRecord(Long id, Double s90, Integer ranks, Integer goalCount,
                             Integer totalShot,
                             Integer onTargetShot, Double distance, Integer freekick,
                             Integer countOfPenaltyKickMade, Integer countOfPenaltyKickAttempted) {
        super(id, s90, ranks);
        this.goalCount = goalCount;
        this.totalShot = totalShot;
        this.onTargetShot = onTargetShot;
        this.distance = distance;
        this.freekick = freekick;
        this.countOfPenaltyKickMade = countOfPenaltyKickMade;
        this.countOfPenaltyKickAttempted = countOfPenaltyKickAttempted;
    }
}
