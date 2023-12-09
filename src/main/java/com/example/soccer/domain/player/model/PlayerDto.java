package com.example.soccer.domain.player.model;

import java.util.List;

public record PlayerDto() {
    public record PostBulk(String squadName, List<PlayerInformation> players) {}
    public record PlayerInformation(String Name, String img, Integer SquadNumber) {}
}
