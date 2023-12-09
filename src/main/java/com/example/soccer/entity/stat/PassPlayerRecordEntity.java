package com.example.soccer.entity.stat;

import com.example.soccer.entity.PlayerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player_pass_records")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PassPlayerRecordEntity extends PlayerRecordEntity {
    private Integer totalDistance;
    private Integer progressiveDistance;
    private Integer shortAttempted;
    private Double shortCompletedPercentage;
    private Integer shortCompletedCount;
    private Double mediumAttempted;
    private Double mediumCompletedPercentage;
    private Integer mediumCompletedCount;
    private Integer longAttempted;
    private Double longCompletedPercentage;
    private Double longCompletedCount;
    private Double assist;
    private Double expectedAssistedGoal;
    private Double expectedAssist;
    private Integer keyPass;
    private Integer finalThirdPass;
    private Integer penaltyAreaPass;
    private Integer penaltyAreaCrossPass;
    private Integer progressivePass;

    public PassPlayerRecordEntity(PlayerEntity playerEntity, Double _90s, Integer ranks,
                                  Integer totalDistance, Integer progressiveDistance,
                                  Integer shortAttempted,
                                  Double shortCompletedPercentage, Integer shortCompletedCount,
                                  Double mediumAttempted, Double mediumCompletedPercentage,
                                  Integer mediumCompletedCount, Integer longAttempted,
                                  Double longCompletedPercentage, Double longCompletedCount,
                                  Double assist,
                                  Double expectedAssistedGoal, Double expectedAssist, Integer keyPass,
                                  Integer finalThirdPass, Integer penaltyAreaPass,
                                  Integer penaltyAreaCrossPass, Integer progressivePass) {
        super(playerEntity, _90s, ranks);
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
