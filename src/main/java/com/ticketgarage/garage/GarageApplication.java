package com.ticketgarage.garage;

import com.ticketgarage.garage.model.Garage;
import com.ticketgarage.garage.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageApplication.class, args);
	}

	@Autowired
	GarageRepository garageRepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// insert garage slot when started GarageApplication
			List<Garage> garageList = new ArrayList<>();
			for (int i=1; i<=10; i++) {
				Garage garage = new Garage();
				String slotName = String.valueOf(i);
				garage.setSlot(slotName);
				garage.setCar(null);
				garageList.add(garage);
			};
			garageRepository.saveAll(garageList);
		};
	}
}
