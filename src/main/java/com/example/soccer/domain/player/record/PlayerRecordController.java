package com.example.soccer.domain.player.record;

import com.example.soccer.CsvParser;
import com.example.soccer.domain.player.position.PositionRepository;
import com.example.soccer.domain.squad.SquadService;
import com.example.soccer.entity.NationEntity;
import com.example.soccer.entity.NationRepository;
import com.example.soccer.entity.PlayerEntity;
import com.example.soccer.entity.PositionEntity;
import com.example.soccer.entity.SquadEntity;
import com.example.soccer.entity.stat.StandardPlayerRecordEntity;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("records")
class PlayerRecordController {

    private final CsvParser csvParser;
    private final PlayerRecordService service;
    @PostMapping("standard-csv")
    public void insertStandards(MultipartFile file) {
        List<CSVRecord> csVrecords = csvParser.getCSVrecords(file);
        csVrecords.forEach(service::insertStandardPlayerRecord);
    }

    @PostMapping("pass-csv")
    public void insertPass(MultipartFile file) {
        List<CSVRecord> csVrecords = csvParser.getCSVrecords(file);
        csVrecords.forEach(service::insertPasslayerRecord);
    }
    @PostMapping("gk-csv")
    public void insertGK(MultipartFile file) {
        List<CSVRecord> csVrecords = csvParser.getCSVrecords(file);
        csVrecords.forEach(service::insertGoalKeepPlayerRecord);
    }

    @PostMapping("depend-csv")
    public void insertDP(MultipartFile file) {
        List<CSVRecord> csVrecords = csvParser.getCSVrecords(file);
        csVrecords.forEach(service::insertDependPlayerRecord);
    }

    @PostMapping("shoot-csv")
    public void insertSH(MultipartFile file) {
        List<CSVRecord> csVrecords = csvParser.getCSVrecords(file);
        csVrecords.forEach(service::insertSTPlayerRecord);
    }
}
