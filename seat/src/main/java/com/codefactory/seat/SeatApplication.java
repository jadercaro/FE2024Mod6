package com.codefactory.seat;

import com.codefactory.seat.model.Seat;
import com.codefactory.seat.model.SeatClass;
import com.codefactory.seat.repository.SeatClassRepository;
import com.codefactory.seat.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SeatApplication implements CommandLineRunner {
	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private SeatClassRepository seatClassRepository;

	private static final Logger logger =
			LoggerFactory.getLogger
			(SeatApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SeatApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource( );
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:3000");
		config.addAllowedHeader("*");
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}

	@Override
	public void run(String... args) throws Exception {
		SeatClass seatClass1 = new SeatClass("Turista");
		SeatClass seatClass2 = new SeatClass("Primera Clase");

		Seat seat1 = new Seat(
				seatClass1,
				"Disponible",
				"Ventana",
				"T-1",
				"0");

		Seat seat2 = new Seat(
				seatClass1,
				"Disponible",
				"Ventana",
				"T-2",
				"0");
		Seat seat3 = new Seat(
				seatClass2,
				"Disponible",
				"Ventana",
				"PC-1",
				"10");

		seatRepository.saveAll(Arrays.asList(seat1, seat2,
				seat3));
		for (Seat seat : seatRepository.findAll()) {
			logger.info(seat.getSeatLabel() + " "+
					seat.getSeatClass().getSeatClassType());
		}
	}
}
