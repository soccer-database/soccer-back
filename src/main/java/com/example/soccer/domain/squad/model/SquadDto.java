package com.example.soccer.domain.squad.model;

import com.example.soccer.domain.classes.Stadium;
import com.example.soccer.entity.SquadEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record SquadDto() {

    public record BulkPatch(@Valid List<PatchSquad> squads) {

    }

    public record PatchSquad(@NotNull String name,@NotNull LocalDate founded, @NotNull Stadium stadium, @NotNull String owner,
                             @NotNull String manager) {

    }

    public record GETMatches(List<Match> matches) {}
    public record Match(int week, Long id, String homeSquadName, String awaySquadName, int homeScore,
                        int awayScore, LocalDate matchDate, LocalTime matchStartTime) {}
}
