package com.example.soccer.domain.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(Include.NON_NULL)
public class SquadSummary {
    private String name;
    private String color;

    public SquadSummary(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
