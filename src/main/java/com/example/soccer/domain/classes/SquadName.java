package com.example.soccer.domain.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SquadName {
    Arsenal("Arsenal"), Aston_Villa("Aston Villa"), Bournemouth("Bournemouth"), Brentford(
        "Brentford"), Brighton("Brighton"), Chelsea("Chelsea"), Crystal_Palace("Crystal Palace"),
    Everton("Everton"), Fulham("Fulham"), Leeds_United("Leeds United"), Leicester_City("Leicester City"),
    Liverpool("Liverpool"), Manchester_City("Manchester City"), Manchester_Utd("Manchester Utd")
    ,Newcastle_Utd("Newcastle Utd"), Nottham_Forest("Nott'ham Forest"), Southampton("Southampton")
    ,Tottenham("Tottenham"), West_Ham("West Ham"), Wolves("Wolves");
    public final String name;
    @JsonCreator
    public static SquadName codeOf(String code) {
        return Arrays.stream(SquadName.values())
            .filter(t -> t.name.equals(code))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(code  + " is illegal argument."));
    }
    @JsonValue
    public String toString() {
        return name;
    }
}
