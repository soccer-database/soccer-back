package com.example.soccer.domain.squad;

import com.example.soccer.CsvParser;
import com.example.soccer.domain.classes.SquadDetail;
import com.example.soccer.domain.classes.SquadName;
import com.example.soccer.domain.squad.model.SquadDto.BulkPatch;
import com.example.soccer.domain.squad.model.SquadDto.Match;
import com.example.soccer.entity.SquadEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("squads")
@RequiredArgsConstructor
class SquadController {

    private final SquadService service;
    private final CsvParser csvParser;
    private final SquadMapper mapper = SquadMapper.INSTANCE;

    @GetMapping("{name}")
    public SquadDetail getDetail(@PathVariable @NotNull SquadName name) {
        System.out.println("name = " + name.name);
        return service.getSquadDetailBy(name.name);
    }

    @PatchMapping("bulk")
    public void patchBulk(@RequestBody @Valid BulkPatch dto) {
        List<SquadEntity> sources = dto.squads().stream().map(mapper::toEntity).toList();
        service.patchBulk(sources);
    }

    @PostMapping("matches/csv")
    public void createMatches(MultipartFile file) {
        List<CSVRecord> csVrecords = csvParser.getCSVrecords(file);
        service.postMatches(csVrecords);
    }

    @GetMapping("{name}/matches")
    public List<Match> getMatchesBySquad(@PathVariable SquadName name) {
        return service.getMatches(name).stream().map(
            entity -> new Match(entity.getWeek(), entity.getId(), entity.getHomeSquad().getName(),
                entity.getAwaySquad().getName(), entity.getHomeScore(), entity.getAwayScore(),
                entity.getMatchDate(), entity.getMatchStartTime())).toList();
    }
}
