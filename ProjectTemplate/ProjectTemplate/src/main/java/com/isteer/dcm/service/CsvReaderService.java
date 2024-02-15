package com.isteer.dcm.service;

import com.isteer.dcm.model.OnStartupDataLoader;
import com.isteer.dcm.model.Production;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderService {

    public List<Production> readCsvFile(String filePath) {
        List<Production> productions = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext();
            String[] line;
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

            while ((line = reader.readNext()) != null) {
                Production production = new Production();
                production.setUpc(line[0]);
                production.setProductName(line[1]);
                production.setProductDescription(line[2]);
                production.setManufacturingDate(LocalDate.parse(line[3], dateFormatter));
                production.setExpiryDate(LocalDate.parse(line[4], dateFormatter));
                production.setStoreId(Integer.parseInt(line[5]));
                production.setStoreName(line[6]);
                production.setStoreAddress(line[7]);
                production.setRegionId(line[8]);
                production.setRegionName(line[9]);
                production.setSalesCount(Integer.parseInt(line[10]));
                production.setProductCategory(line[11]);
                production.setStockInStore(Integer.parseInt(line[12]));
                production.setRefillFrequency(line[13]);
                production.setCompetitorProductsAvailable(line[14].equalsIgnoreCase("Y"));
                production.setCollectionStatus(line[15]);
                production.setStockStatus(line[16]);
                productions.add(production);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return productions;
    }
}
