package com.codefactory.seat.service;

import com.codefactory.seat.model.Seat;
import com.codefactory.seat.model.SeatClass;
import com.codefactory.seat.model.SeatLocation;
import com.codefactory.seat.model.SeatStatus;
import com.codefactory.seat.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service

public class GenerateSeatsImpl implements IGenerateSeats{

    @Autowired
    private SeatRepository seatRepository;
    @Override
    public Iterable<Seat> createSeats(int nSeats) {
        SeatClass seatClass1 = new SeatClass(Long.valueOf("1"), SeatClass.Type.TOURIST);
        SeatStatus seatStatus1 = new SeatStatus(Long.valueOf("1"), SeatStatus.Status.AVAILABLE);
        SeatLocation center = new SeatLocation(Long.valueOf("1"), SeatLocation.Location.CENTER);

        Seat seat1 = new Seat(
                seatClass1,
                seatStatus1,
                center,
                "T-5",
                "0");

        Seat seat2 = new Seat(
                seatClass1,
                seatStatus1,
                center,
                "T-10",
                "0");

        return seatRepository.saveAll(Arrays.asList(seat1, seat2));
    }
}
