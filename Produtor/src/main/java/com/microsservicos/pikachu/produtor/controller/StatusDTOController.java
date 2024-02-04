package com.microsservicos.pikachu.produtor.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservicos.pikachu.produtor.dto.StatusDTO;
import com.microsservicos.pikachu.produtor.service.StatusDTOService;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;


@RestController
@RequestMapping("/status")
public class StatusDTOController {


		@Autowired
		private StatusDTOService statusDtoService;
		
	 	@PostMapping()
        public ResponseEntity<List<StatusDTO>> getAll() throws IllegalStateException, FileNotFoundException{
        	
            String fileName = "src/main/resources/conciliation-data.csv";
            
            CSVParser csvParser = new CSVParserBuilder()
                    .withSeparator(';') // Set your custom delimiter here
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName))
                    .withCSVParser(csvParser)
                    .build();
            
            
            List<StatusDTO> beans = new CsvToBeanBuilder<StatusDTO>(csvReader)
                    .withType(StatusDTO.class)
                    
                    .build()
                    .parse();
            	 statusDtoService.enviarMensagensParaRabbitMQ();
            	
            return ResponseEntity.ok(beans);
           
        }
    
}