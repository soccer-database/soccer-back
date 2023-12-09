package com.example.soccer.domain.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(Include.NON_NULL)
public class SquadDetail {

    private String manager;
    private LocalDate founded;
    private String owner;
    private Stadium stadium;
    private String name;
    private String color;

    public SquadDetail(String manager, LocalDate founded, String owner, Stadium stadium,
                       String name, String color) {
        this.manager = manager;
        this.founded = founded;
        this.owner = owner;
        this.stadium = stadium;
        this.name = name;
        this.color = color;
    }
}
