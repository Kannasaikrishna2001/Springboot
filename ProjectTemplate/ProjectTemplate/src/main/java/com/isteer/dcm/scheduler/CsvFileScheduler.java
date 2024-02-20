package com.isteer.dcm.scheduler;

import com.isteer.dcm.model.Production;
import com.isteer.dcm.service.CsvReaderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
@EnableScheduling
@Component
public class CsvFileScheduler {

    private final CsvReaderService csvReaderService;

    @Value("${csv.file.path}")
    private String filePath;

    public CsvFileScheduler(CsvReaderService csvReaderService) {
        this.csvReaderService = csvReaderService;
    }

    @Scheduled(cron = "${csv.file.parser.cron.expression}")
    public void parseCsvFile() {
        List<Production> productions = csvReaderService.readCsvFile(filePath);
    }
}
