package com.veera;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public List<Long> getIds() {
        List<Long> ids = new ArrayList<>();
        {
            try {
                InputStream is = new FileInputStream("");
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
                Iterable<CSVRecord> csvRecords = csvParser.getRecords();
                for(CSVRecord csvRecord : csvRecords) {
                    Long id = Long.valueOf(csvRecord.get("id"));
                    ids.add(id);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ids;
    }
}