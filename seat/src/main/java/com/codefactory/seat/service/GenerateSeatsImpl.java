package com.codefactory.seat.service;

import com.codefactory.seat.model.Seat;
import com.codefactory.seat.model.SeatClass;
import com.codefactory.seat.model.SeatLocation;
import com.codefactory.seat.model.SeatStatus;
import com.codefactory.seat.repository.SeatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service

public class GenerateSeatsImpl implements IGenerateSeats{
    
    @Autowired
    private SeatRepository seatRepository;

    //Método para generar una lista de asientos recibiendo la cantidad de asientos a crear
    @Override
    public Iterable<Seat> createSeats(int nSeats) {



        //Se instancia los tipos de clases
        SeatClass seatClass1 = new SeatClass(Long.valueOf("1"), SeatClass.Type.TOURIST);
        SeatClass seatClass2 = new SeatClass(Long.valueOf("2"), SeatClass.Type.EXECUTIVE);
        SeatClass seatClass3 = new SeatClass(Long.valueOf("3"),SeatClass.Type.FIRST_CLASS);

        //Se crea el estado del asiento inicial
        SeatStatus seatStatus1 = new SeatStatus(Long.valueOf("1"), SeatStatus.Status.AVAILABLE);

        //Se crea las ubicaciones de los asientos
        SeatLocation center = new SeatLocation(Long.valueOf("1"), SeatLocation.Location.CENTER);
        SeatLocation window = new SeatLocation(Long.valueOf("2"), SeatLocation.Location.WINDOW);
        SeatLocation aisle = new SeatLocation(Long.valueOf("3"), SeatLocation.Location.AISLE);

        //Inicializamos la lista de asientos
        List<Seat> seats = new ArrayList<>();

        //Asignamos las distribuciones generales entre clases del avión 70% para Turista
        int countSeatClass1 = (int) (0.7 * nSeats);
		int countSeatClass2 = (int) (0.15 * nSeats);
		int countSeatClass3 = nSeats-countSeatClass1-countSeatClass2;

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
            SeatStatus seatStatus = seatStatus1;
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
            SeatStatus seatStatus = seatStatus1;
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

        return seatRepository.saveAll(seats);
    }
}
