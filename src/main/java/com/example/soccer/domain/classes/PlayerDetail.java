package com.example.soccer.domain.classes;


import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayerDetail extends Player{
    private String nation;
    private Integer birthYear;
    private SquadSummary squad;

    public PlayerDetail(Long id, String profileUrl, String name, Integer backNumber,
                        Set<String> positions, String nation, Integer birthYear, SquadSummary squad) {
        super(id, profileUrl, name, backNumber, positions);
        this.nation = nation;
        this.birthYear = birthYear;
        this.squad = squad;
    }
}
