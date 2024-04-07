package com.codefactory.seat;

import com.codefactory.seat.model.Seat;
import com.codefactory.seat.model.SeatClass;
import com.codefactory.seat.model.SeatLocation;
import com.codefactory.seat.model.SeatStatus;
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
		SeatClass seatClass1 = new SeatClass(Long.valueOf("1"), SeatClass.Type.TOURIST);
		SeatClass seatClass2 = new SeatClass(Long.valueOf("2"), SeatClass.Type.EXECUTIVE);

		SeatStatus seatStatus1 = new SeatStatus(Long.valueOf("1"), SeatStatus.Status.AVAILABLE);
		SeatStatus seatStatus2 = new SeatStatus(Long.valueOf("2"), SeatStatus.Status.OCCUPIED);

		SeatLocation center = new SeatLocation(Long.valueOf("1"), SeatLocation.Location.CENTER);
		SeatLocation window = new SeatLocation(Long.valueOf("2"), SeatLocation.Location.WINDOW);

		Seat seat1 = new Seat(
				seatClass1,
				seatStatus1,
				center,
				"T-1",
				"0");

		Seat seat2 = new Seat(
				seatClass1,
				seatStatus1,
				center,
				"T-2",
				"0");
		Seat seat3 = new Seat(
				seatClass2,
				seatStatus2,
				window,
				"E-1",
				"10");

		seatRepository.saveAll(Arrays.asList(seat1, seat2,
				seat3));
		for (Seat seat : seatRepository.findAll()) {
			logger.info(seat.getSeatLabel() + " "+
					seat.getSeatClass().getType().name());
		}
	}
}
