package com.dom.pelu;

import com.dom.pelu.entity.*;
import com.dom.pelu.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PeluApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeluApplication.class, args);
	}

}
