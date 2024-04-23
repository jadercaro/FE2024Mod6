package com.codefactory.seat.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class SeatxPassenger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "SEAT_PASSENGER_SEQ", allocationSize = 1)
    Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_passenger")
    private Passenger passenger;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_seat")
    private Seat seat;

    public SeatxPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    
    
}
