package com.example.soccer.domain.player.record;

import com.example.soccer.domain.classes.PlayerRecordType;
import com.example.soccer.domain.classes.stat.PlayerRecord;
import com.example.soccer.domain.player.PlayerService;
import com.example.soccer.domain.squad.SquadService;
import com.example.soccer.entity.PlayerEntity;
import com.example.soccer.entity.SquadEntity;
import com.example.soccer.entity.stat.DependPlayerRecordEntity;
import com.example.soccer.entity.stat.GoalKeepPlayerRecordEntity;
import com.example.soccer.entity.stat.PassPlayerRecordEntity;
import com.example.soccer.entity.stat.PlayerRecordEntity;
import com.example.soccer.entity.stat.ShootPlayerRecordEntity;
import com.example.soccer.entity.stat.StandardPlayerRecordEntity;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlayerRecordService {

    private final PlayerRecordMapper mapper = PlayerRecordMapper.INSTANCE;
    private final PlayerRecordReader reader;
    private final PlayerRecordWriter writer;
    private final PlayerService playerService;
    private final SquadService squadService;

    public PlayerRecord getPlayerRecordBy(Long id, PlayerRecordType type) {
        PlayerRecordEntity recordEntity = reader.readBy(id, type);
        return mapper.toPlayerRecord(recordEntity);
    }

    @Transactional
    public void insertDependPlayerRecord(CSVRecord csVrecord) {
        DependPlayerRecordEntity standardPlayerRecord = new DependPlayerRecordEntity(
            getPlayer(csVrecord), Double.valueOf(csVrecord.get(7)),
            Integer.valueOf(csVrecord.get(0)), Integer.valueOf(csVrecord.get(8)),
            Integer.valueOf(csVrecord.get(9)), Integer.valueOf(csVrecord.get(10)),
            Integer.valueOf(csVrecord.get(11)), Integer.valueOf(csVrecord.get(12)),
            Integer.valueOf(csVrecord.get(13)), Integer.valueOf(csVrecord.get(14)),
            Integer.valueOf(csVrecord.get(16)), Integer.valueOf(csVrecord.get(17)),
            Integer.valueOf(csVrecord.get(18)), Integer.valueOf(csVrecord.get(19)),
            Integer.valueOf(csVrecord.get(21)));
        writer.save(standardPlayerRecord);
    }

    @Transactional
    public void insertSTPlayerRecord(CSVRecord csVrecord) {
//        Integer goalCount, Integer totalShot, Integer onTargetShot, Double distance, Integer
//        freekick, Integer countOfPenaltyKickMade, Integer countOfPenaltyKickAttempted
        ShootPlayerRecordEntity standardPlayerRecord = new ShootPlayerRecordEntity(
            getPlayer(csVrecord), Double.valueOf(csVrecord.get(7)),
            Integer.valueOf(csVrecord.get(0)), Integer.valueOf(csVrecord.get(8)),
            Integer.valueOf(csVrecord.get(9)), Integer.valueOf(csVrecord.get(10)),
            Double.valueOf(csVrecord.get(16)), Integer.valueOf(csVrecord.get(17)),
            Integer.valueOf(csVrecord.get(18)), Double.valueOf(csVrecord.get(19)));
        writer.save(standardPlayerRecord);
    }

    @Transactional

    public void insertStandardPlayerRecord(CSVRecord csVrecord) {
        StandardPlayerRecordEntity standardPlayerRecord = new StandardPlayerRecordEntity(
            getPlayer(csVrecord), Double.valueOf(csVrecord.get(10)),
            Integer.valueOf(csVrecord.get(0)), Integer.valueOf(csVrecord.get(7)),
            Integer.valueOf(csVrecord.get(8)),
            Integer.valueOf(csVrecord.get(9).replaceAll(",", "")),
            Integer.valueOf(csVrecord.get(11).replaceAll(",", "")),
            Integer.valueOf(csVrecord.get(15)), Integer.valueOf(csVrecord.get(16)),
            Integer.valueOf(csVrecord.get(17)), Integer.valueOf(csVrecord.get(18)),
            Double.valueOf(csVrecord.get(19)), Double.valueOf(csVrecord.get(20)),
            Double.valueOf(csVrecord.get(21)), Integer.valueOf(csVrecord.get(25)),
            Integer.valueOf(csVrecord.get(23)), Integer.valueOf(csVrecord.get(24)));
        writer.save(standardPlayerRecord);
    }

    //PlayerEntity playerEntity, Double _90s, Integer ranks,
//                                  Integer totalDistance, Integer progressiveDistance,
//                                  Integer shortAttempted,
//                                  Double shortCompletedPercentage, Integer shortCompletedCount,
//                                  Integer mediumAttempted, Double mediumCompletedPercentage,
//                                  Integer mediumCompletedCount, Integer longAttempted,
//                                  Double longCompletedPercentage, Integer longCompletedCount,
//                                  Double assist,
//                                  Double expectedAssistedGoal, Double expectedAssist, Integer keyPass,
//                                  Integer finalThirdPass, Integer penaltyAreaPass,
//                                  Integer penaltyAreaCrossPass, Integer progressivePass
    @Transactional
    public void insertPasslayerRecord(CSVRecord csVrecord) {
        PassPlayerRecordEntity standardPlayerRecord = new PassPlayerRecordEntity(
            getPlayer(csVrecord), Double.valueOf(csVrecord.get(7)),
            Integer.valueOf(csVrecord.get(0)), Integer.valueOf(csVrecord.get(11)),
            Integer.valueOf(csVrecord.get(12)), Integer.valueOf(csVrecord.get(14)),
            Double.valueOf(csVrecord.get(15)), Integer.valueOf(csVrecord.get(16)),
            Double.valueOf(csVrecord.get(17)), Double.valueOf(csVrecord.get(18)),
            Integer.valueOf(csVrecord.get(19)), Integer.valueOf(csVrecord.get(20)),
            Double.valueOf(csVrecord.get(21)), Double.valueOf(csVrecord.get(22)),
            Double.valueOf(csVrecord.get(23)), Double.valueOf(csVrecord.get(24)),
            Double.valueOf(csVrecord.get(25)), Integer.valueOf(csVrecord.get(26)),
            Integer.valueOf(csVrecord.get(27)), Integer.valueOf(csVrecord.get(28)),
            Integer.valueOf(csVrecord.get(29)), Integer.valueOf(csVrecord.get(30)));
        writer.save(standardPlayerRecord);
    }

    //PlayerEntity playerEntity, Double _90s, Integer ranks,
//                                      Integer goalsAgainst, Integer shootsOnTargetAgainst, Integer saves,
//                                      Integer wins, Integer draws, Integer loses, Integer cleanSheets,
//                                      Integer penaltyKickAttempted, Integer penaltyKickAgainsts,
//                                      Integer penaltyKickSaves, Integer penaltyKickMisses
    @Transactional
    public void insertGoalKeepPlayerRecord(CSVRecord csVrecord) {
        GoalKeepPlayerRecordEntity standardPlayerRecord = new GoalKeepPlayerRecordEntity(
            getPlayer(csVrecord), Double.valueOf(csVrecord.get(10)),
            Integer.valueOf(csVrecord.get(0)), Integer.valueOf(csVrecord.get(11)),
            Integer.valueOf(csVrecord.get(13)), Integer.valueOf(csVrecord.get(14)),
            Integer.valueOf(csVrecord.get(16)), Integer.valueOf(csVrecord.get(17)),
            Integer.valueOf(csVrecord.get(18)), Integer.valueOf(csVrecord.get(19)),
            Integer.valueOf(csVrecord.get(21)), Integer.valueOf(csVrecord.get(22)),
            Integer.valueOf(csVrecord.get(23)), Integer.valueOf(csVrecord.get(24)));
        writer.save(standardPlayerRecord);
    }


    private PlayerEntity getPlayer(CSVRecord record) {
        SquadEntity squad = squadService.readBy(record.get("Squad"));
        return playerService.readBy(squad.getName(), record.get("Player"));
    }
}
