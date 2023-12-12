package com.example.soccer.domain.squad;

import com.example.soccer.domain.classes.SquadName;
import com.example.soccer.domain.classes.SquadSummary;
import com.example.soccer.domain.classes.SquadDetail;
import com.example.soccer.domain.squad.model.SquadDto.Match;
import com.example.soccer.entity.SquadEntity;
import com.example.soccer.entity.SquadMatchRecordEntity;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SquadService {

    private final SquadReader reader;
    private final SquadWriter writer;
    private final SquadRecordWriter recordWriter;
    private final SquadRecordReader recordReader;
    private final SquadMapper mapper = SquadMapper.INSTANCE;

    public SquadSummary getSquadSummaryBy(Long playerId) {
        return mapper.toDomain(reader.getSquadBy(playerId));
    }

    @Transactional
    public void insertByName(String name) {
       writer.save(mapper.toEntity(name));;
    }

    public SquadEntity readBy(String name) {
        return reader.getSquadBy(name);
    }

    public SquadDetail getSquadDetailBy(String name) {
        return mapper.toDetailDomain(reader.getSquadBy(name));
    }

    @Transactional
    public void patchBulk(List<SquadEntity> squads) {
        Map<String, SquadEntity> map = reader.getMap();
        squads.forEach(s->{
            map.get(s.getName()).patch(s);
        });
    }

    @Transactional
    public void postMatches(List<CSVRecord> records) {
        records.forEach(recordWriter::insertMatchRecord);
    }

    @Transactional(readOnly = true)
    public List<SquadMatchRecordEntity> getMatches(SquadName name) {
        return recordReader.findByTeam(name.name);
    }
}
