package com.example.soccer.domain.classes;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {

    private final Set<String> positions = new LinkedHashSet<>();
    private Long id;
    private String profileUrl;
    private String name;
    private Integer backNumber;


    public Player(Long id, String profileUrl, String name, Integer backNumber,
                  Set<String> positions) {
        this.id = id;
        this.profileUrl = profileUrl;
        this.name = name;
        this.backNumber = backNumber;
        this.positions.addAll(positions);
    }
}
