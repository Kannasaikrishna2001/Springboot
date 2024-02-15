package com.isteer.dcm.scheduler;

import com.isteer.dcm.entity.DcmUsers;
import com.isteer.dcm.model.Production;
import com.isteer.dcm.service.CsvReaderService;
import com.isteer.dcm.service.DataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
@EnableScheduling
@Component
public class CsvFileScheduler {

    private final CsvReaderService csvReaderService;

    /*@Value("${csv.file.path}")
    private String filePath;*/


    public CsvFileScheduler(CsvReaderService csvReaderService) {
        this.csvReaderService = csvReaderService;
    }
    @Autowired
    DataInitializer dataInitializer;

    @Scheduled(cron = "0 57 18 ? * WED")
    public void parseCsvFile() {
        List<DcmUsers> userList=dataInitializer.getDcmUsersList();
        System.out.println(" this is the data loaded on startup "+userList.get(0).getUserid());

       /* List<Production> productions = csvReaderService.readCsvFile(filePath);

        for (Production production : productions) {
            System.out.println(production);
        }*/
    }
}
