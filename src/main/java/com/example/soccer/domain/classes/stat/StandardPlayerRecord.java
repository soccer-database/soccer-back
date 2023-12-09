package com.example.soccer.domain.classes.stat;

import com.example.soccer.entity.PlayerEntity;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class StandardPlayerRecord extends PlayerRecord {
  private final Integer matchPlayCount;
  private final Integer startCount;
  private final Integer playMinutes;
  private final Integer goalCount;
  private final Integer penaltyKickMade;
  private final Integer penaltyKickAttempt;
  private final Integer yellowCard;
  private final Integer redCard;
  private final Double expectedGoal;
  private final Double nonPenaltyExpectedGoal;
  private final Double expectedAssistedGoal;
  private final Integer progressivePassReceive;
  private final Integer progressiveCarry;
  private final Integer progressivePass;

  public StandardPlayerRecord(Long id, Double s90, Integer ranks, Integer matchPlayCount,
                              Integer startCount, Integer playMinutes, Integer goalCount,
                              Integer penaltyKickMade, Integer penaltyKickAttempt,
                              Integer yellowCard,
                              Integer redCard, Double expectedGoal, Double nonPenaltyExpectedGoal,
                              Double expectedAssistedGoal, Integer progressivePassReceive,
                              Integer progressiveCarry, Integer progressivePass) {
    super(id, s90, ranks);
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
