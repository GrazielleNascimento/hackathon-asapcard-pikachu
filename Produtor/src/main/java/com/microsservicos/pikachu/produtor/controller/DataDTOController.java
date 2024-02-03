package com.microsservicos.pikachu.produtor.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservicos.pikachu.produtor.dto.DataDTO;
import com.opencsv.bean.CsvToBeanBuilder;


@RestController
@RequestMapping("/csv")
public class DataDTOController {


		
        @GetMapping("/all")
        public ResponseEntity<List<DataDTO>> getAll() throws IllegalStateException, FileNotFoundException{
        	
            String fileName = "C:\\Dev\\Spring\\hackathon-asapcard-pikachu\\Produtor\\src\\main\\resources\\data.csv";

            List<DataDTO> beans = new CsvToBeanBuilder<DataDTO>(new FileReader(fileName))
                    .withType(DataDTO.class)
                    .build()
                    .parse();
            
            return ResponseEntity.ok(beans);
        }
        
    
    
    
}
