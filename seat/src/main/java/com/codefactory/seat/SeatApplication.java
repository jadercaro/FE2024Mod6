package com.codefactory.seat;

import com.codefactory.seat.model.Seat;
import com.codefactory.seat.model.SeatClass;
import com.codefactory.seat.model.SeatLocation;
import com.codefactory.seat.model.SeatStatus;
import com.codefactory.seat.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SeatApplication implements CommandLineRunner {
	@Autowired
	private SeatRepository seatRepository;

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
		SeatClass seatClass3 = new SeatClass(Long.valueOf("3"),SeatClass.Type.FIRST_CLASS);

		SeatStatus seatStatus1 = new SeatStatus(Long.valueOf("1"), SeatStatus.Status.AVAILABLE);
		SeatStatus seatStatus2 = new SeatStatus(Long.valueOf("2"), SeatStatus.Status.OCCUPIED);

		SeatLocation center = new SeatLocation(Long.valueOf("1"), SeatLocation.Location.CENTER);
		SeatLocation window = new SeatLocation(Long.valueOf("2"), SeatLocation.Location.WINDOW);
		SeatLocation aisle = new SeatLocation(Long.valueOf("3"), SeatLocation.Location.AISLE);

		//Ingresar número de asientos
		int numero_asientos = 100; 

		//Invocar método generador y guardar los asientos 
        List<Seat> seats = generateSeats(numero_asientos, seatClass1, seatClass2,seatClass3, seatStatus1, seatStatus2, center, window, aisle);
        seatRepository.saveAll(seats);

		//imprime por consola
        for (Seat seat : seatRepository.findAll()) {
            logger.info(seat.getSeatLabel() + " " + seat.getSeatClass().getType().name());
		}
	}

	//método generador de asientos
	private List<Seat> generateSeats(int numero_asientos, 
									SeatClass seatClass1, 
									SeatClass seatClass2, 
									SeatClass seatClass3,
    								SeatStatus seatStatus1, 
									SeatStatus seatStatus2,
                                    SeatLocation center, 
									SeatLocation window, 
									SeatLocation aisle) {
        List<Seat> seats = new ArrayList<>();

		//Asignamos las distribuciones generales entre clases del avión 70% para Turista
        int countSeatClass1 = (int) (0.7 * numero_asientos);
		int countSeatClass2 = (int) (0.15 * numero_asientos);
		int countSeatClass3 = numero_asientos-countSeatClass1-countSeatClass2;

		//Asignamos las distribuciones de posición del asiento, 33% para cada clase
        int countWindow = (int) (0.33 * countSeatClass1);
        int countCenter = (int) (0.33 * countSeatClass1);

		//Creamos los asientos de clase Turista
        int seatClassCounter = 1;
        for (int i = 0; i < countSeatClass1; i++) {
            SeatClass seatClass = seatClass1;
            SeatStatus seatStatus = seatStatus1;
            SeatLocation seatType;
            int price;
            if (i < countWindow) {
                seatType = window;
                price = 30000;
            } else if (i < countWindow + countCenter) {
                seatType = center;
                price = 0;
            } else {
                seatType = aisle;
                price = 15000;
            }

            String seatLabel = "T-" + seatClassCounter;
            String priceString = String.valueOf(price);

            Seat seat = new Seat(seatClass, seatStatus, seatType, seatLabel, priceString);
            seats.add(seat);

            seatClassCounter++;
        }
		seatClassCounter = 1;

		//Creamos los asientos de clase Ejecutiva
        for (int i = 0; i < countSeatClass2; i++) {
            SeatClass seatClass = seatClass2;
            SeatStatus seatStatus = seatStatus2;
            SeatLocation seatType; 
            String seatLabel;
            int price;
			int countWindow2 = (int) (0.33 * countSeatClass2); 
        	int countCenter2 = (int) (0.33 * countSeatClass2); 

			if (i <= countWindow2){
				seatType = window;
				price = 75000;
			}
			else if(i <= countCenter2 + countWindow2){
				seatType = center;
				price = 45000;
			}
			else{
				seatType = aisle;
				price = 60000;
			}

			seatLabel = "E-" + seatClassCounter;
			String priceString = String.valueOf(price);
            Seat seat = new Seat(seatClass, seatStatus, seatType, seatLabel, priceString);
            seats.add(seat);

			seatClassCounter++;
        }

		//Creamos los asientos de Primera clase
		seatClassCounter = 1;
        for (int i = 0; i < countSeatClass3; i++) {
            SeatClass seatClass = seatClass3;
            SeatStatus seatStatus = seatStatus2;
            SeatLocation seatType; 
            String seatLabel;
            int price;
			int countWindow3 = (int) (0.33 * countSeatClass3); 
        	int countCenter3 = (int) (0.33 * countSeatClass3); 

			if (i <= countWindow3){
				seatType = window;
				price = 120000;
			}
			else if(i <= countCenter3 + countWindow3){
				seatType = center;
				price = 90000;
			}
			else{
				seatType = aisle;
				price = 105000;
			}

			seatLabel = "F-" + seatClassCounter;
			String priceString = String.valueOf(price);
            Seat seat = new Seat(seatClass, seatStatus, seatType, seatLabel, priceString);
            seats.add(seat);

			seatClassCounter++;
        }

        return seats;
    }
}
