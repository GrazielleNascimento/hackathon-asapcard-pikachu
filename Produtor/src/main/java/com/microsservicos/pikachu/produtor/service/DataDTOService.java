package com.microsservicos.pikachu.produtor.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.microsservicos.pikachu.produtor.dto.DataDTO;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class DataDTOService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

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

    public void enviarMensagensParaRabbitMQ() throws FileNotFoundException {
        List<DataDTO> dataList = dataJson(); // Obtém a lista de DataDTO

        for (DataDTO data : dataList) {
            try {
                // Converte DataDTO para string JSON
                String mensagemJson = objectMapper.writeValueAsString(data);

                // Envia a mensagem em JSON para a fila do RabbitMQ
                rabbitTemplate.convertAndSend( "grazi", mensagemJson);
            } catch (JsonProcessingException e) {
                // Trate a exceção caso ocorra erro na conversão para JSON
                e.printStackTrace();
            }
        }
    }
}
