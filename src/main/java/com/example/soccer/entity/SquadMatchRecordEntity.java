package com.example.soccer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "squad_match_records")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SquadMatchRecordEntity {
    @Id @GeneratedValue
    private Long id;
    private int week;
    @JoinColumn(name = "home_team_name")
    @ManyToOne(fetch = FetchType.LAZY)
    private SquadEntity homeSquad;
    @JoinColumn(name = "away_team_name")
    @ManyToOne(fetch = FetchType.LAZY)
    private SquadEntity awaySquad;
    private int homeScore;
    private int awayScore;
    private LocalDate matchDate;
    private LocalTime matchStartTime;

    public SquadMatchRecordEntity(int week, SquadEntity homeSquad, SquadEntity awaySquad,
                                  int homeScore, int awayScore, LocalDate matchDate,
                                  LocalTime matchStartTime) {
        this.week = week;
        this.homeSquad = homeSquad;
        this.awaySquad = awaySquad;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.matchDate = matchDate;
        this.matchStartTime = matchStartTime;
    }
}
