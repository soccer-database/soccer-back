package com.example.soccer.entity.stat;

import com.example.soccer.entity.PlayerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "player_shoot_records")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShootPlayerRecordEntity extends PlayerRecordEntity {
    private Integer goalCount;
    private Integer totalShot;
    private Integer onTargetShot;
    private Double distance;
    private Integer freekick;
    private Integer countOfPenaltyKickMade;
    private Double countOfPenaltyKickAttempted;

    public ShootPlayerRecordEntity(PlayerEntity playerEntity, Double _90s, Integer ranks,
                                   Integer goalCount, Integer totalShot, Integer onTargetShot,
                                   Double distance, Integer freekick, Integer countOfPenaltyKickMade,
                                   Double countOfPenaltyKickAttempted) {
        super(playerEntity, _90s, ranks);
        this.goalCount = goalCount;
        this.totalShot = totalShot;
        this.onTargetShot = onTargetShot;
        this.distance = distance;
        this.freekick = freekick;
        this.countOfPenaltyKickMade = countOfPenaltyKickMade;
        this.countOfPenaltyKickAttempted = countOfPenaltyKickAttempted;
    }
}
