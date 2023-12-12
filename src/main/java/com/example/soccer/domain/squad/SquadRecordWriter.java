package com.example.soccer.domain.squad;

import com.example.soccer.entity.SquadMatchRecordEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SquadRecordWriter {

    private final SquadRecordWriteRepository repository;
    private final SquadReader squadReader;

    @Transactional
    public void insertMatchRecord(CSVRecord csVrecord) {
        String score = csVrecord.get(6);
        String[] scores = score.split("–");
        SquadMatchRecordEntity record = new SquadMatchRecordEntity(Integer.parseInt(csVrecord.get(0)),
            squadReader.getSquadBy(csVrecord.get(4)), squadReader.getSquadBy(csVrecord.get(8)),
            Integer.parseInt(scores[0]), Integer.parseInt(scores[1]),
            LocalDate.parse(csVrecord.get(2)), LocalTime.parse(csVrecord.get(3)));
        repository.save(record);
    }
}
