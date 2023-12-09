package com.example.soccer.entity.stat;

import com.example.soccer.entity.PlayerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player_standard_records")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StandardPlayerRecordEntity extends PlayerRecordEntity {
  private Integer matchPlayCount;
  private Integer startCount;
  private Integer playMinutes;
  private Integer goalCount;
  private Integer penaltyKickMade;
  private Integer penaltyKickAttempt;
  private Integer yellowCard;
  private Integer redCard;
  private Double expectedGoal;
  private Double nonPenaltyExpectedGoal;
  private Double expectedAssistedGoal;
  private Integer progressivePassReceive;
  private Integer progressiveCarry;
  private Integer progressivePass;

  public StandardPlayerRecordEntity(PlayerEntity playerEntity, Double _90s, Integer ranks,
                                    Integer matchPlayCount, Integer startCount, Integer playMinutes,
                                    Integer goalCount, Integer penaltyKickMade,
                                    Integer penaltyKickAttempt,
                                    Integer yellowCard, Integer redCard, Double expectedGoal,
                                    Double nonPenaltyExpectedGoal, Double expectedAssistedGoal,
                                    Integer progressivePassReceive, Integer progressiveCarry,
                                    Integer progressivePass) {
    super(playerEntity, _90s, ranks);
    this.matchPlayCount = matchPlayCount;
    this.startCount = startCount;
    this.playMinutes = playMinutes;
    this.goalCount = goalCount;
    this.penaltyKickMade = penaltyKickMade;
    this.penaltyKickAttempt = penaltyKickAttempt;
    this.yellowCard = yellowCard;
    this.redCard = redCard;
    this.expectedGoal = expectedGoal;
    this.nonPenaltyExpectedGoal = nonPenaltyExpectedGoal;
    this.expectedAssistedGoal = expectedAssistedGoal;
    this.progressivePassReceive = progressivePassReceive;
    this.progressiveCarry = progressiveCarry;
    this.progressivePass = progressivePass;
  }
}
