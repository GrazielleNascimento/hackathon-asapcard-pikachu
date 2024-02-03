package com.microsservicos.pikachu.produtor;

import java.io.FileReader;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microsservicos.pikachu.produtor.dto.DataDTO;
import com.opencsv.bean.CsvToBeanBuilder;

@SpringBootApplication
public class ProdutorApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProdutorApplication.class, args);

		String fileName = "input-data.csv";

		List<DataDTO> beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(DataDTO.class).build().parse();

		beans.forEach(System.out::println);

	}

}
