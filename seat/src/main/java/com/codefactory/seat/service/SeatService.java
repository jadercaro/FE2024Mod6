package com.codefactory.seat.service;

import com.codefactory.seat.model.Seat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SeatService {

    private Stream<Seat> prepareStreamOfSeats() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("seats.json");
            if (inputStream != null) {
                Seat[] seats = objectMapper.readValue(inputStream, Seat[].class);
                return Arrays.stream(seats);
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo archivo JSON", e);
        }
    }

    private boolean isSeatAvailable(String str){
        String strClean  = str.replaceAll("\\s+","");
        return strClean.equalsIgnoreCase("disponible");
    }
    public List<List<Seat>> getAvailableSeats() {
        try {
            return Arrays.asList(
                    prepareStreamOfSeats()
                            .filter(seat -> isSeatAvailable(seat.getSeatStatus()))
                            .collect(Collectors.toList()));
        } catch (NullPointerException e) {
            throw new RuntimeException("Error filtering by availability.", e);
        }
    }

    // Método para crear la distribución de los asientos
    // public List<List<Seat>> createSeatDistribution()



}
