package com.isteer.dcm.components;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.isteer.dcm.model.Production;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class ProductComponent {

    public List<Production> readProductsFromCsv() {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.registerModule(new JavaTimeModule());
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        ObjectReader oReader = csvMapper.reader(Production.class).with(schema);
        List<Production> products = new ArrayList<>();
        try (Reader reader = new FileReader("D:\\Createfile\\SpringBoot\\csvfile\\ProductCollection.csv")) {
            MappingIterator<Production> mi = oReader.readValues(reader);
            while (mi.hasNext()) {
                Production current = mi.next();
                products.add(current);
                System.out.println(current);
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println("Number of products in the list: " + products.size());
        return products;
    }
}
