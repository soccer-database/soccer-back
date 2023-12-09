package com.example.soccer.domain.squad.model;

import com.example.soccer.domain.classes.Stadium;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record SquadDto() {

    public record BulkPatch(@Valid List<PatchSquad> squads) {

    }

    public record PatchSquad(@NotNull String name,@NotNull LocalDate founded, @NotNull Stadium stadium, @NotNull String owner,
                             @NotNull String manager) {

    }
}
