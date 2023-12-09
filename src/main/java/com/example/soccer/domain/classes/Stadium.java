package com.example.soccer.domain.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
public record Stadium(@NotNull String name, @NotNull Double latitude, @NotNull Double longitude,
                      @NotNull Integer capacity) {

}
