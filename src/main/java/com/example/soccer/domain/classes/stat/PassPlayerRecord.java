package com.example.soccer.domain.classes.stat;

import com.example.soccer.entity.PlayerEntity;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PassPlayerRecord extends PlayerRecord {
    private final Integer totalDistance;
    private final Integer progressiveDistance;
    private final Integer shortAttempted;
    private final Double shortCompletedPercentage;
    private final Integer shortCompletedCount;
    private final Integer mediumAttempted;
    private final Double mediumCompletedPercentage;
    private final Integer mediumCompletedCount;
    private final Integer longAttempted;
    private final Double longCompletedPercentage;
    private final Integer longCompletedCount;
    private final Double assist;
    private final Double expectedAssistedGoal;
    private final Double expectedAssist;
    private final Integer keyPass;
    private final Integer finalThirdPass;
    private final Integer penaltyAreaPass;
    private final Integer penaltyAreaCrossPass;
    private final Integer progressivePass;

    public PassPlayerRecord(Long id, Double s90, Integer ranks, Integer totalDistance,
                            Integer progressiveDistance, Integer shortAttempted,
                            Double shortCompletedPercentage, Integer shortCompletedCount,
                            Integer mediumAttempted, Double mediumCompletedPercentage,
                            Integer mediumCompletedCount, Integer longAttempted,
                            Double longCompletedPercentage, Integer longCompletedCount,
                            Double assist,
                            Double expectedAssistedGoal, Double expectedAssist, Integer keyPass,
                            Integer finalThirdPass, Integer penaltyAreaPass,
                            Integer penaltyAreaCrossPass, Integer progressivePass) {
        super(id, s90, ranks);
        this.totalDistance = totalDistance;
        this.progressiveDistance = progressiveDistance;
        this.shortAttempted = shortAttempted;
        this.shortCompletedPercentage = shortCompletedPercentage;
        this.shortCompletedCount = shortCompletedCount;
        this.mediumAttempted = mediumAttempted;
        this.mediumCompletedPercentage = mediumCompletedPercentage;
        this.mediumCompletedCount = mediumCompletedCount;
        this.longAttempted = longAttempted;
        this.longCompletedPercentage = longCompletedPercentage;
        this.longCompletedCount = longCompletedCount;
        this.assist = assist;
        this.expectedAssistedGoal = expectedAssistedGoal;
        this.expectedAssist = expectedAssist;
        this.keyPass = keyPass;
        this.finalThirdPass = finalThirdPass;
        this.penaltyAreaPass = penaltyAreaPass;
        this.penaltyAreaCrossPass = penaltyAreaCrossPass;
        this.progressivePass = progressivePass;
    }
}
