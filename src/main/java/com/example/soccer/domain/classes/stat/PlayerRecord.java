package com.example.soccer.domain.classes.stat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
public abstract class PlayerRecord {
    private final Long id;
    private final Double s90;
    private final Integer ranks;

    protected PlayerRecord(Long id, Double s90, Integer ranks) {
        this.id = id;
        this.s90 = s90;
        this.ranks = ranks;
    }
}
