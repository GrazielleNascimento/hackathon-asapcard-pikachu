package com.microsservicos.pikachu.produtor.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microsservicos.pikachu.produtor.dto.DataDTO;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class DataDTOService {

    public List<DataDTO> dataJson() throws IllegalStateException, FileNotFoundException {

    	String fileName = "src/main/resources/data.csv";

        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(';')
                .build();

        CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName))
                .withCSVParser(csvParser)
                .build();


        List<DataDTO> beans = new CsvToBeanBuilder<DataDTO>(csvReader)
                .withType(DataDTO.class)
                .build()
                .parse();

        return beans;

    }



}